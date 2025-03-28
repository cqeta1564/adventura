package command;

import item.Item;
import item.ItemFactory;
import observer.Observable;
import player.Hrac;
import singleton.Mistnost;

import java.util.Random;
import java.util.Scanner;

/**
 * Příkaz pro kradení předmětů z místnosti.
 * Třída dědí od třídy {@link Command}.
 */
public class Krast extends Command {

    private Random random;
    private Mistnost currentMistnost;
    private Scanner scanner;
    private Observable observable;
    private Hrac hrac;

    public Krast(Random random, Mistnost currentMistnost, Scanner scanner, Observable observable, Hrac hrac) {
        this.random = random;
        this.currentMistnost = currentMistnost;
        this.scanner = scanner;
        this.observable = observable;
        this.hrac = hrac;
    }

    //TODO: Opravit chybu, kdy muze hrac ukrast veci z jine mistnosti
    @Override
    public String execute() {

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
    public boolean exit() {
        return false;
    }

    @Override
    public void setter(String argument) {

    }
}
