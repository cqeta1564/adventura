package command;

import item.Item;
import item.ItemFactory;
import observer.Observable;
import singleton.Mistnost;
import player.*;
import java.util.Scanner;

public class Koupit extends Command {
    @Override
    public String execute(Hrac hrac, Mistnost currentMistnost, Scanner scanner, Observable observable) {
        ItemFactory itemFactory = new ItemFactory();

        System.out.println("Co chcete koupit?");
        String itemName = scanner.nextLine();
        Item item = itemFactory.createItem(itemName);
        if(item == null){
            System.out.println("Takový předmět neexistuje");
            return "";
        }

        System.out.println("Kolik chcete koupit?");
        int pocet = scanner.nextInt();
        if(pocet*item.getCena() > hrac.getInventar().getPenize()){
            System.out.println("Nemáte dostatek peněz");
            return "";
        }
        for (int i = 0; i < pocet; i++) {
            hrac.getInventar().addItem(item);
        }
        return "Koupili jste " + pocet + "x " + item.getNazev();
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
