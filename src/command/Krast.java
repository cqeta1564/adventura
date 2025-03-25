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

    //TODO: Opravit chybu, kdy muze hrac ukrast veci z jine mistnosti
    @Override
    public String execute(Hrac hrac, Mistnost currentMistnost, Scanner scanner, Observable observable, String druheSlovo) {

        // Kontrola mistnosti
        if (!(currentMistnost.getName().equals("pocitacova ucebna") || currentMistnost.getName().equals("fyzikalni ucebna"))) {
            return "Tady nemůžeš krást";
        }

        System.out.println("> Co chceš ukrást?");

        String itemName = scanner.nextLine();

        if (random.nextInt(100) < 50) { // 50% šance, že hráč bude přistižen
            System.out.println("> Šatnář: Co to bylo?");
            observable.notifyObservers("kradez");
        }

        Item ukradenyItem = ItemFactory.createItem(itemName);
        if (!(ukradenyItem == null)) {
            hrac.getInventar().addItem(ukradenyItem);
            return "Ukradl jsi: " + ukradenyItem.getNazev();
        }

        return "Takový předmět neexistuje";
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
