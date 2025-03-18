package command;

import player.Hrac;
import singleton.Mistnost;

public class Progress extends Command {
    @Override
    public String execute(Hrac hrac, Mistnost currentMistnost) {
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
