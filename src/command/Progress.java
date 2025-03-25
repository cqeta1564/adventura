package command;

import observer.Observable;
import player.Hrac;
import singleton.Mistnost;

import java.util.Scanner;

//TODO: Nebude mozna ani za potrebi. Command tu byl z duvodu satnare, ktery si nas stejne hlida a pokud si neceho vsimne vtahne nas do nuceneho rozhovoru, kde neni potreba specifikovat prikaz mluv a v pripade questu reditele se dialog automaticky spusti pri vstupu do reditelny.
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
