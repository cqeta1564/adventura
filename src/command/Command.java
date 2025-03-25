package command;

import observer.Observable;
import player.Hrac;
import singleton.Mistnost;

import java.util.Scanner;

/**
 * Abstraktní třída představující příkaz ve hře.
 */
public abstract class Command {

    /**
     * Spustí příkaz.
     * @return Výstup příkazu
     */
    public abstract String execute(Hrac hrac, Mistnost currentMistnost, Scanner scanner, Observable observable, String druheSlovo);

    /**
     * Přesune hráče do jiné místnosti.
     * @param currentMistnost Aktuální místnost hráče
     * @param nextMistnostName Název místnosti, do které se hráč chce přesunout
     * @return Nová místnost, pokud přesun proběhne úspěšně, jinak původní místnost
     */
    public abstract Mistnost move(Mistnost currentMistnost, String nextMistnostName, Observable observable);

    /**
     * Určuje, zda příkaz ukončuje hru.
     * @return true, pokud příkaz ukončuje hru, jinak false
     */
    public abstract boolean exit();
}
