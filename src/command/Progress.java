package command;

import player.Hrac;

public class Progress extends Command {

    private Hrac hrac;

    public Progress(Hrac hrac) {
        this.hrac = hrac;
    }

    @Override
    public String execute() {
        return "Máte " + hrac.getInventar().getPenize() + " peněz";
    }

    @Override
    public boolean exit() {
        return false;
    }

    @Override
    public void setter(String argument) {

    }
}
