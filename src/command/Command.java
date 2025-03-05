package command;
import singleton.Mistnost;

/**
 * Abstraktní třída představující příkaz ve hře.
 */
public abstract class Command {

    /**
     * Spustí příkaz.
     * @return Výstup příkazu
     */
    public abstract String execute();

    //TODO: Dopsat JavaDocs
    public abstract Mistnost move(Mistnost currentMistnost, String nextMistnostName);

    /**
     * Určuje, zda příkaz ukončuje hru.
     * @return true, pokud příkaz ukončuje hru, jinak false
     */
    public abstract boolean exit();
}
