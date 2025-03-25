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
        ItemFactory itemFactory = new ItemFactory();

        System.out.println("Co chcete prodat?");
        System.out.println(hrac.getInventar().showItems());
        String itemName = scanner.nextLine();

        for (int i = 0; i < hrac.getInventar().getSize(); i++) {
            if(hrac.getInventar().getItem(i).getNazev().equals(itemName)){
                hrac.getInventar().addPenize(hrac.getInventar().getItem(i).getCena());
                hrac.getInventar().removeItem(hrac.getInventar().getItem(i));
                return "Prodali jste " + itemName;
            }
        }
        return "Item nenalezen";
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
