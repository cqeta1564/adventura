package command;

import singleton.Mistnost;

public class Progress extends Command {
    @Override
    public String execute() {
        return "";
    }

    @Override
    public String move(Mistnost currentMistnost) {
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
