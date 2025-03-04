package command;

import singleton.Mistnost;

public class Konec extends Command {
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
        return true;
    }
}
