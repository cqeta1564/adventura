package command;

/**
 * Příkaz pro zobrazení seznamu dostupných příkazů.
 * Třída dědí od třídy {@link Command}.
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
    public boolean exit() {
        return false;
    }

    @Override
    public void setter(String argument) {

    }
}
