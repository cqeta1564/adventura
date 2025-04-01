package command;

import player.Hrac;

/**
 * Příkaz pro kontrolu aktuálního progressu ve hře.
 * Třída dědí od třídy {@link Command}.
 */
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
