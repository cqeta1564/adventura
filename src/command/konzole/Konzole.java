package command.konzole;

import command.*;
import observer.*;
import singleton.*;
import player.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.Normalizer;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Třída zpracovávající vstup uživatele a provádějící příkazy.
 */
public class Konzole {
    private Scanner sc = new Scanner(System.in);
    private boolean exit = false;
    private HashMap<String, Command> mapa;
    public static String souborPrikazu = "res/historiePrikazu.txt";
    private Svet svet;
    private Mistnost currentMistnost;
    public Hrac hrac;
    private Observable observable;

    private void inicializace() {
        mapa = new HashMap<>();
        mapa.put("jdi", new Jdi());
        mapa.put("konec", new Konec());
        mapa.put("koupit", new Koupit());
        mapa.put("krast", new Krast());
        mapa.put("mluv", new Mluv());
        mapa.put("napoveda", new Napoveda());
        mapa.put("pomoc", new Pomoc());
        mapa.put("prodat", new Prodat());
        mapa.put("progress", new Progress());
    }

    /**
     * Spustí konzoli a čeká na vstup uživatele.
     */
    public void start() {
        inicializace();

        //Zacatek kodu pro ovladani sveta ----------------------------------------
        SvetLoader.loadWorld(); //Za pomoci SvetLoaderu nacteme svet
        this.svet = Svet.getInstance(); //Vpiseme nacteny svet do Svetu
        this.currentMistnost = svet.getRoom("venku"); //Zacneme ve mistnosti "venku"
        //Konec kodu pro ovladani sveta ------------------------------------------

        this.hrac = new Hrac();

        //Zacatek testovaciho kodu pro satnare -----------------------------------
        this.observable = new Observable();
        this.observable.addObserver(new Satnar(this.hrac));
        //Konec testovaciho kodu pro satnare -------------------------------------

        try { //Projistotu try-catch, ale nemel by byt za potrebi
            resetSouboruProPrikazy();
            while (!exit) {
                provedPrikaz();
            }
            this.sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void provedPrikaz() {
        System.out.print(">");
        String prikaz = sc.nextLine();
        prikaz = prikaz.trim(); //Remove leading and trailing whitespaces
        prikaz = prikaz.toLowerCase(); //Convert to lowercase
        prikaz = Normalizer.normalize(prikaz, Normalizer.Form.NFD); //Remove diacritics
        prikaz = prikaz.replaceAll("\\p{InCombiningDiacriticalMarks}+", ""); //Remove diacritics
        ulozPrikaz(prikaz);
        String[] slova = prikaz.split(" "); //Rozkladani prikazu na samostatna slova
        if (mapa.containsKey(slova[0])) {
            System.out.print("> ");
            //                        prikaz            hrac     , aktualni mistnost   , scanner, info pro satnare, predmet na kradez/prodani/mnozstvi pri koupi
            System.out.print(mapa.get(slova[0]).execute(this.hrac, this.currentMistnost, this.sc, this.observable, slova[1]));
            try {
                currentMistnost = mapa.get(slova[0]).move(currentMistnost, slova[1], this.observable);
            } catch (Exception e) {
                System.out.println();
                System.out.println("> Chybne zadany prikaz");
            }
            exit = mapa.get(slova[0]).exit(); //Resime prikaz ukonceni
        } else {
            System.out.println("> Nedefinovany prikaz");
        }
    }

    private void ulozPrikaz(String prikaz) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(souborPrikazu, true))) {
            bw.write(prikaz);
            bw.newLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void resetSouboruProPrikazy() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(souborPrikazu, false))) {
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
