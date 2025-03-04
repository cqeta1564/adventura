package command.konzole;

import command.*;
import singleton.Mistnost;
import singleton.Svet;
import singleton.SvetLoader;

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
    public static String souborPrikazu = "souborPrikazu.txt";

    //Zacatek testovaciho kodu pro ovladani sveta ----------------------------------------
    Svet svet;
    Mistnost currentMistnost;
    //Konec testovaciho kodu pro ovladani sveta ------------------------------------------

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

        //Zacatek testovaciho kodu pro ovladani sveta ----------------------------------------
        SvetLoader.loadWorld(); //Za pomoci SvetLoaderu nacteme svet
        svet = Svet.getInstance(); //Vpiseme nacteny svet do Svetu
        currentMistnost = svet.getRoom("venku"); //Zacneme ve mistnosti "venku"
        //Konec testovaciho kodu pro ovladani sveta ------------------------------------------

        try {
            resetSouboruProPrikazy();
            do {
                provedPrikaz();
            } while (!exit);
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
        if (mapa.containsKey(prikaz)) {
            System.out.println("> " + mapa.get(prikaz).execute());
            System.out.println("> " + mapa.get(prikaz).move(currentMistnost));
            exit = mapa.get(prikaz).exit();
        } else {
            System.out.println("> Nedefinovany prikaz");
        }
    }

    private void ulozPrikaz(String prikaz) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(souborPrikazu, true))) {
            bw.write(prikaz);
            bw.newLine();
        } catch (Exception e) {

        }
    }

    private void resetSouboruProPrikazy() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(souborPrikazu, false))) {
        } catch (Exception e) {
        }
    }
}
