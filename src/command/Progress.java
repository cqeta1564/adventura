package command;

import player.Hrac;

//TODO: Nebude mozna ani za potrebi. Command tu byl z duvodu satnare, ktery si nas stejne hlida a pokud si neceho vsimne vtahne nas do nuceneho rozhovoru, kde neni potreba specifikovat prikaz mluv a v pripade questu reditele se dialog automaticky spusti pri vstupu do reditelny.
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
