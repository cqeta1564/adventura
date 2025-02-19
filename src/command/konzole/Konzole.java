package command.konzole;

import command.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;

public class Konzole {
    private Scanner sc = new Scanner(System.in);
    private boolean exit = false;
    private HashMap<String, Command> mapa;
    public static String souborPrikazu = "souborPrikazu.txt";

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

    public void start() {
        inicializace();
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
        prikaz = prikaz.trim();
        prikaz = prikaz.toLowerCase();
        ulozPrikaz(prikaz);
        if (mapa.containsKey(prikaz)) {
            System.out.println("> " + mapa.get(prikaz).execute());
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
