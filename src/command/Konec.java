package command;

import observer.Observable;
import player.Hrac;
import singleton.Mistnost;

import java.util.Scanner;

/**
 * Příkaz pro ukončení hry.
 * Třída dědí od třídy {@link Command}.
 */
public class Konec extends Command {
    @Override
    public String execute(Hrac hrac, Mistnost currentMistnost, Scanner scanner, Observable observable, String druheSlovo) {
        return "";
    }

    @Override
    public Mistnost move(Mistnost currentMistnost, String nextMistnostName, Observable observable) {
        return currentMistnost;
    }

    @Override
    public boolean exit() {
        return true;
    }
}
