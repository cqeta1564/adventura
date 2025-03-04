package command;

import singleton.Mistnost;

public class Napoveda extends Command {
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
