package command.konzole;

import command.*;
import observer.*;
import singleton.*;
import player.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.Normalizer;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 * Třída zpracovávající vstup uživatele a provádějící příkazy.
 * <p>
 * Tato třída spravuje uživatelský vstup a vykonává příkazy ve hře. Také spravuje
 * pohyb hráče mezi místnostmi a interakci s prostředím.
 */
public class Konzole {
    private Scanner sc;
    private Random random;
    private boolean exit = false;
    private HashMap<String, Command> mapa;
    public static String souborPrikazu = "res/historiePrikazu.txt";
    private Svet svet;
    private Mistnost currentMistnost;
    public Hrac hrac;
    private Observable observable;

    /**
     * Inicializuje mapu příkazů, které může uživatel zadat.
     */
    private boolean inicializacePrikazu() {
        try {
            mapa = new HashMap<>();
            mapa.put("jdi", new Jdi(currentMistnost, observable));
            mapa.put("konec", new Konec());
            mapa.put("koupit", new Koupit(currentMistnost, sc, hrac));
            mapa.put("krast", new Krast(random, currentMistnost, sc, observable, hrac));
            mapa.put("mluv", new Mluv());
            mapa.put("napoveda", new Napoveda(currentMistnost));
            mapa.put("pomoc", new Pomoc());
            mapa.put("prodat", new Prodat(currentMistnost, hrac, sc));
            mapa.put("progress", new Progress(hrac));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private boolean inicializaceObjektu() {
        try {
            this.hrac = new Hrac();

            this.observable = new Observable();
            this.observable.addObserver(new Satnar(this.hrac));

            this.sc = new Scanner(System.in);
            this.random = new Random();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private boolean inicializaceSveta() {
        try {
            SvetLoader.loadWorld(); //Za pomoci SvetLoaderu nacteme svet
            this.svet = Svet.getInstance(); //Vpiseme nacteny svet do Svetu
            this.currentMistnost = svet.getRoom("venku"); //Zacneme ve mistnosti "venku"
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private boolean inicializaceHistoriePrikazu() {
        try {
            resetSouboruProPrikazy();
        } catch (Exception e) {
            System.out.println("> Nebylo možné resetovat historii příkazů. Následující chybu prosím hlašte správci projektu: ");
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * Spustí konzoli a čeká na vstup uživatele.
     * Hráč zadává příkazy, které jsou následně zpracovávány a vykonávány.
     */
    public void start() {
        inicializaceSveta();
        inicializaceObjektu();
        inicializacePrikazu();
        inicializaceHistoriePrikazu();

        try { //Projistotu try-catch, ale nemel by byt za potrebi
            while (!exit) {
                provedPrikaz();
            }
        } catch (Exception e) {
            System.out.println("> Nastala neočekávaná chyba. Prosím restartujte program a následující chybu hlašte správci projektu: ");
            System.out.println(e.getMessage());
        }

        this.sc.close();
    }

    private String ziskatText() {
        return sc.nextLine();
    }

    private String normalizovatText(String prikaz) {
        prikaz = prikaz.trim(); //Remove leading and trailing whitespaces
        prikaz = prikaz.toLowerCase(); //Convert to lowercase
        prikaz = Normalizer.normalize(prikaz, Normalizer.Form.NFD); //Remove diacritics
        prikaz = prikaz.replaceAll("\\p{InCombiningDiacriticalMarks}+", ""); //Remove diacritics
        return prikaz;
    }

    private String[] rozdelitText(String prikaz) {
        return prikaz.split(" "); //Rozkladani prikazu na samostatna slova
    }

    /**
     * Zpracuje jeden příkaz zadaný uživatelem a vykoná ho.
     */
    private void provedPrikaz() {
        System.out.print("> ");
        String prikaz = ziskatText();

        prikaz = normalizovatText(prikaz);

        ulozPrikaz(prikaz);

        String[] slova = rozdelitText(prikaz);

        if (mapa.containsKey(slova[0])) {
            System.out.print("> ");

            try {
                mapa.get("jdi").setter(slova[1]);
                System.out.print(mapa.get(slova[0]).execute());
            } catch (Exception e) {
                System.out.println();
                System.out.println("> Chybně zadaný příkaz");
            }
            exit = mapa.get(slova[0]).exit(); //Resime prikaz ukonceni
        } else {
            System.out.println("> Nedefinovaný příkaz");
        }
    }

    /**
     * Uloží provedený příkaz do souboru historie příkazů.
     *
     * @param prikaz Příkaz, který byl proveden
     */
    private boolean ulozPrikaz(String prikaz) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(souborPrikazu, true))) {
            bw.write(prikaz);
            bw.newLine();
        } catch (Exception e) {
            System.out.println("> Nebylo možné uložit příkaz do souboru. Následující chybu prosím hlašte správci projektu: ");
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * Resetuje soubor historie příkazů, tím že ho přepíše prázdným souborem.
     */
    private void resetSouboruProPrikazy() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(souborPrikazu, false))) {
        } catch (Exception e) {
            System.out.println("> Nebylo možné resetovat historii příkazů. Následující chybu prosím hlašte správci projektu: ");
            System.out.println(e.getMessage());
        }
    }

    // =========================Settery a gettery pro UNIT testy========================================
    public boolean getUlozPrikaz(String prikaz) {
        return ulozPrikaz(prikaz);
    }

    public boolean getInicializaceSveta() {
        return inicializaceSveta();
    }

    public boolean getInicializaceObjektu() {
        return inicializaceObjektu();
    }

    public boolean getInicializacePrikazu() {
        return inicializacePrikazu();
    }

    public boolean getInicializaceHistoriePrikazu() {
        return inicializaceHistoriePrikazu();
    }

    public String getZiskatText() {
        return ziskatText();
    }

    public String getNormalizovatText(String prikaz) {
        return normalizovatText(prikaz);
    }

    public String[] getRozdelitText(String prikaz) {
        return rozdelitText(prikaz);
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public boolean isExit() {
        return exit;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }

    public HashMap<String, Command> getMapa() {
        return mapa;
    }

    public void setMapa(HashMap<String, Command> mapa) {
        this.mapa = mapa;
    }

    public static String getSouborPrikazu() {
        return souborPrikazu;
    }

    public static void setSouborPrikazu(String souborPrikazu) {
        Konzole.souborPrikazu = souborPrikazu;
    }

    public Svet getSvet() {
        return svet;
    }

    public void setSvet(Svet svet) {
        this.svet = svet;
    }

    public Mistnost getCurrentMistnost() {
        return currentMistnost;
    }

    public void setCurrentMistnost(Mistnost currentMistnost) {
        this.currentMistnost = currentMistnost;
    }

    public Hrac getHrac() {
        return this.hrac;
    }

    public void setHrac(Hrac hrac) {
        this.hrac = hrac;
    }

    public Observable getObservable() {
        return observable;
    }

    public void setObservable(Observable observable) {
        this.observable = observable;
    }
}
