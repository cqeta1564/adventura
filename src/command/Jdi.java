package command;

import player.Hrac;
import singleton.Mistnost;

public class Jdi extends Command {
    @Override
    public String execute(Hrac hrac, Mistnost currentMistnost) {
        return "";
    }

    @Override
    public Mistnost move(Mistnost currentMistnost, String nextMistnostName) { //Zde se bude provadet pohyb
            System.out.print("Posunuli jste se z " + currentMistnost.getName());

            Mistnost nextMistnost = currentMistnost.getNeighbor(nextMistnostName);
            if (nextMistnost != null) {
                currentMistnost = nextMistnost;
                System.out.println(" do " + currentMistnost.getName());
                return currentMistnost;
            } else {
                System.out.println("Tato místnost neexistuje nebo tam nemůžete jít.");
            }
            return currentMistnost;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
