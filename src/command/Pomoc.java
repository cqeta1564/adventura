package command;

import player.Hrac;
import singleton.Mistnost;

import java.util.Scanner;

/**
 * Příkaz zobrazující dostupné příkazy ve hře.
 */
public class Pomoc extends Command {
    @Override
    public String execute(Hrac hrac, Mistnost currentMistnost, Scanner scanner) {
        return """
                Dostupné příkazy:
                jdi <místnost> - přesune hráče do zadané místnosti
                konec - ukončí hru
                koupit <množství> - nakoupí kontrabant
                krast <předmět> - ukradne vybavení z aktuální místonosti
                mluv <osoba> - zahájí dialog s postavou
                nápověda - vypíše nápovědu jak dále ve hře pokračovat
                pomoc - vypíše příkazy
                prodat <množství/předmět> - prodá kontrabant nebo ukradené vybavení
                progress - zobrazí postup ve hře
                """;
    }

    @Override
    public Mistnost move(Mistnost currentMistnost, String nextMistnostName) {
        return currentMistnost;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
