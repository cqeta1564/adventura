package command;

import observer.Observable;
import player.Hrac;
import singleton.Mistnost;

import java.util.Objects;
import java.util.Scanner;

/**
 * Příkaz pro pohyb hráče do jiné místnosti.
 *
 * Tento příkaz umožňuje hráči se přesunout mezi místnostmi v herním světě.
 */
public class Jdi extends Command {
    @Override
    public String execute(Hrac hrac, Mistnost currentMistnost, Scanner scanner, Observable observable, String druheSlovo) {
        return "";
    }

    @Override
    public Mistnost move(Mistnost currentMistnost, String nextMistnostName, Observable observable) { //Zde se bude provadet pohyb
            System.out.print("Posunuli jste se z " + currentMistnost.getName());

            Mistnost nextMistnost = currentMistnost.getNeighbor(nextMistnostName);
            boolean notifyObservers = false; //Pro jistotu vytvarim uz tady, at si s tim garbage collector poradi
            if (nextMistnost != null) {
                //TODO: Otestovat tento if, protoze si myslim, ze nebude fungovat tak, jak chci
                if (Objects.equals(currentMistnost.getName(), "venku") && Objects.equals(nextMistnost.getName(), "chodba")) {
                    notifyObservers = false;
                } else if (Objects.equals(nextMistnost.getName(), "chodba")) {
                    notifyObservers = true;
                }
                currentMistnost = nextMistnost;
                System.out.println(" do " + currentMistnost.getName());
                if (notifyObservers) {
                    observable.notifyObservers("chodba");
                }
                return currentMistnost;
            } else {
                System.out.println("Tato místnost neexistuje nebo tam nemůžete jít.");
            }
            return currentMistnost;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
