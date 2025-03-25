package command;

import observer.Observable;
import player.Hrac;
import singleton.Mistnost;

import java.util.Scanner;

/**
 * Abstraktní třída představující příkaz ve hře.
 *
 * Každý příkaz v hře dědí od této třídy a implementuje konkrétní chování.
 */
public abstract class Command {

    /**
     * Spustí příkaz.
     *
     * @param hrac Hráč, který provádí příkaz
     * @param currentMistnost Aktuální místnost, ve které se hráč nachází
     * @param scanner Scanner pro získání vstupu od uživatele
     * @param observable Objekt pro sledování událostí ve hře
     * @param druheSlovo Druhý parametr příkazu, pokud je potřeba
     * @return Výstup příkazu
     */
    public abstract String execute(Hrac hrac, Mistnost currentMistnost, Scanner scanner, Observable observable, String druheSlovo);

    /**
     * Přesune hráče do jiné místnosti.
     *
     * @param currentMistnost Aktuální místnost hráče
     * @param nextMistnostName Název místnosti, do které se hráč chce přesunout
     * @param observable Objekt pro sledování událostí ve hře
     * @return Nová místnost, pokud přesun proběhne úspěšně, jinak původní místnost
     */
    public abstract Mistnost move(Mistnost currentMistnost, String nextMistnostName, Observable observable);

    /**
     * Určuje, zda příkaz ukončuje hru.
     *
     * @return true, pokud příkaz ukončuje hru, jinak false
     */
    public abstract boolean exit();
}
