package command;

import singleton.Mistnost;

/**
 * Příkaz zobrazující dostupné příkazy ve hře.
 */
public class Pomoc extends Command {
    @Override
    public String execute() {
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
    public String move(Mistnost currentMistnost) {
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
