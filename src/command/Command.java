package command;

/**
 * Abstraktní třída představující příkaz ve hře.
 */
public abstract class Command {

    /**
     * Spustí příkaz.
     *
     * @return Výstup příkazu
     */
    public abstract String execute();

    /**
     * Určuje, zda příkaz ukončuje hru.
     *
     * @return true, pokud příkaz ukončuje hru, jinak false
     */
    public abstract boolean exit();

    public abstract void setter(String argument);
}
