package command;

import item.Item;
import item.ItemFactory;
import observer.Observable;
import player.Hrac;
import singleton.Mistnost;

import java.util.Scanner;

public class Prodat extends Command {
    @Override
    public String execute(Hrac hrac, Mistnost currentMistnost, Scanner scanner, Observable observable, String druheSlovo) {
        int pocet = 0;
        switch (currentMistnost.getName()) {
            case "za skolou":
                System.out.println("Co chcete prodat?");
                System.out.println(hrac.getInventar().showItems());

                String itemName = scanner.nextLine();

                if (!(itemName.equals("kontraband") || itemName.equals("promitacka") || itemName.equals("monitor") || itemName.equals("pocitac"))) {
                    return "Byl vybrán neznámý item";
                }

                System.out.println("Kolik chcete prodat?");
                System.out.println(hrac.getInventar().showItems());

                try {
                    pocet = scanner.nextInt();
                } catch (Exception e) {
                    return "Vyskytla se chyba";
                }

                if (pocet <= 0 || pocet > hrac.getInventar().pocetItemu(itemName)) {
                    return "Počet je mimo rozsah";
                }

                hrac.getInventar().removeItem("kontraband", pocet);
                return "Prodal jsi " + pocet + "x " + itemName;

            case "zachody":
                if (hrac.getInventar().pocetItemu("kontraband") == 0) {
                    return "Nevlastníš žádný kontraband, nelze žádný prodat";
                }

                System.out.println("Kolik chcete prodat kontrabandu? (vlastníš" + hrac.getInventar().pocetItemu("kontraband") + ")");

                try {
                    pocet = scanner.nextInt();
                } catch (Exception e) {
                    return "Vyskytla se chyba";
                }

                if (pocet <= 0 || pocet > hrac.getInventar().pocetItemu("kontraband")) {
                    return "Počet je mimo rozsah";
                }

                hrac.getInventar().removeItem("kontraband", pocet);
                return "Prodal jsi " + pocet + "x kontraband";

            default:
                return "Nejsi v místnosti, kde můžes prodávat.";
        }

        return "Tohle nikdy neuvidíš :)";
    }

    @Override
    public Mistnost move(Mistnost currentMistnost, String nextMistnostName, Observable observable) {
        return currentMistnost;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
