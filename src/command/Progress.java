package command;

import observer.Observable;
import player.Hrac;
import singleton.Mistnost;

import java.util.Scanner;

public class Progress extends Command {
    @Override
    public String execute(Hrac hrac, Mistnost currentMistnost, Scanner scanner, Observable observable, String druheSlovo) {
        return "Máte " + hrac.getInventar().getPenize() + " peněz";
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
