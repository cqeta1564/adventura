package command;

import item.Item;
import item.ItemFactory;
import singleton.Mistnost;
import player.*;

import java.util.Scanner;

public class Koupit extends Command {

    private Mistnost currentMistnost;
    private Scanner scanner;
    private Hrac hrac;

    public Koupit(Mistnost currentMistnost, Scanner scanner, Hrac hrac) {
        this.currentMistnost = currentMistnost;
        this.scanner = scanner;
        this.hrac = hrac;
    }

    @Override
    public String execute() {

        Item item = ItemFactory.createItem("kontraband");

        if (!(currentMistnost.getName().equals("za skolou"))) {
            return "Tady nemůžete nakupovat";
        }

        System.out.println("Kolik chcete koupit kontrabandu?");

        int pocet = scanner.nextInt();
        assert item != null; //nevim co to dela, ale Idea mi to sem dala kvuli moznemu null pointeru
        if (pocet * 100 > hrac.getInventar().getPenize()) { //cena kontrabandu je pro nakup pouze 100
            return "Nemáte dostatek peněz";
        }

        for (int i = 0; i < pocet; i++) {
            hrac.getInventar().addItem(item);
        }

        return "Koupili jste " + pocet + "x " + item.getNazev();

    }

    @Override
    public boolean exit() {
        return false;
    }

    @Override
    public void setter(String argument) {

    }
}
