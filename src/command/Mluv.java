package command;

//TODO: Nebude mozna ani za potrebi. Command tu byl z duvodu satnare, ktery si nas stejne hlida a pokud si neceho vsimne vtahne nas do nuceneho rozhovoru, kde neni potreba specifikovat prikaz mluv a v pripade questu reditele se dialog automaticky spusti pri vstupu do reditelny.
/**
 * Příkaz pro komunikaci s postavami.
 * Třída dědí od třídy {@link Command}.
 */
public class Mluv extends Command {
    @Override
    public String execute() {
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }

    @Override
    public void setter(String argument) {

    }
}
