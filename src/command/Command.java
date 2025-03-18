package command;

import player.Hrac;
import singleton.Mistnost;

/**
 * Abstraktní třída představující příkaz ve hře.
 */
public abstract class Command {

    /**
     * Spustí příkaz.
     * @return Výstup příkazu
     */
    public abstract String execute(Hrac hrac, Mistnost currentMistnost);

    /**
     * Přesune hráče do jiné místnosti.
     * @param currentMistnost Aktuální místnost hráče
     * @param nextMistnostName Název místnosti, do které se hráč chce přesunout
     * @return Nová místnost, pokud přesun proběhne úspěšně, jinak původní místnost
     */
    public abstract Mistnost move(Mistnost currentMistnost, String nextMistnostName);

    /**
     * Určuje, zda příkaz ukončuje hru.
     * @return true, pokud příkaz ukončuje hru, jinak false
     */
    public abstract boolean exit();
}
