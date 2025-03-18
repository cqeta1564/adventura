package command;

import player.Hrac;
import singleton.Mistnost;

import java.util.Scanner;

public class Progress extends Command {
    @Override
    public String execute(Hrac hrac, Mistnost currentMistnost, Scanner scanner) {
        return "Tato ficura bude pridana az se programator bude nudit. Tato sïtuace zatim nenastala.";
    }

    @Override
    public Mistnost move(Mistnost currentMistnost, String nextMistnostName) {
        return currentMistnost;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
