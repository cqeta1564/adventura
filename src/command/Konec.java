package command;

import player.Hrac;
import singleton.Mistnost;

public class Konec extends Command {
    @Override
    public String execute(Hrac hrac, Mistnost currentMistnost) {
        return "";
    }

    @Override
    public Mistnost move(Mistnost currentMistnost, String nextMistnostName) {
        return currentMistnost;
    }

    @Override
    public boolean exit() {
        return true;
    }
}
