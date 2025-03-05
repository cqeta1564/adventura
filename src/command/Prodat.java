package command;

import singleton.Mistnost;

public class Prodat extends Command {
    @Override
    public String execute() {
        return "";
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
