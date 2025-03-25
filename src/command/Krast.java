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
    public String execute(Hrac hrac, Mistnost currentMistnost, Scanner scanner, Observable observable) {
        // Možnost krádeže je dostupná jen v určitých místnostech
        if (!isStealAllowed(currentMistnost)) {
            return "Zde není co ukrást.\n";
        }

        if (random.nextInt(100) < 30) { // 30% šance, že hráč bude přistižen
            System.out.println("> Šatnář: Co to bylo?");
            observable.notifyObservers("kradez");
        }



        Item ukradenyItem = ItemFactory.createItem("cigarety"); // Lze rozšířit o různé předměty
        hrac.getInventar().addItem(ukradenyItem);
        return "Ukradl jsi: " + ukradenyItem.getNazev() + "\n";
    }

    private boolean isStealAllowed(Mistnost mistnost) {
        return mistnost.getName().equals("sklad") || mistnost.getName().equals("trida") || mistnost.getName().equals("chodba");
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
