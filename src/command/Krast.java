package command;

import item.Item;
import item.ItemFactory;
import observer.Observable;
import player.Hrac;
import singleton.Mistnost;

import java.util.Random;
import java.util.Scanner;

public class Krast extends Command {

    private static final Random random = new Random();

    @Override
    public String execute(Hrac hrac, Mistnost currentMistnost, Scanner scanner, Observable observable, String druheSlovo) {

        if (random.nextInt(100) < 30) { // 30% šance, že hráč bude přistižen
            System.out.println("> Šatnář: Co to bylo?");
            observable.notifyObservers("kradez");
        }

        Item ukradenyItem = ItemFactory.createItem("cigarety"); // Lze rozšířit o různé předměty
        hrac.getInventar().addItem(ukradenyItem);
        return "Ukradl jsi: " + ukradenyItem.getNazev() + "\n";
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
