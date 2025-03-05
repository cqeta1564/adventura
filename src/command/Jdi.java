package command;
import singleton.Mistnost;

public class Jdi extends Command {
    @Override
    public String execute() {
        return "provadim prikaz jdi... volam metodu move()";
    }

    @Override
    public Mistnost move(Mistnost currentMistnost, String nextMistnostName) { //Zde se bude provadet pohyb
        while (true) {
            System.out.print("Posunuli jste se z " + currentMistnost.getName());

            Mistnost nextMistnost = currentMistnost.getNeighbor(nextMistnostName);
            if (nextMistnost != null) {
                currentMistnost = nextMistnost;
                System.out.println(" do " + currentMistnost.getName());
                return currentMistnost;
            } else {
                System.out.println("Tato místnost neexistuje nebo tam nemůžete jít.");
            }
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
