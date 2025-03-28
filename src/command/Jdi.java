package command;

import observer.Observable;
import singleton.Mistnost;

import java.util.Objects;

public class Jdi extends Command {

    Mistnost currentMistnost;
    Observable observable;
    String nextMistnostName;

    public Jdi(Mistnost mistnost, Observable observable) {
        this.currentMistnost = mistnost;
        this.observable = observable;
        this.nextMistnostName = "";
    }


    @Override
    public String execute() {
        System.out.print("Posunuli jste se z " + currentMistnost.getName());

        Mistnost nextMistnost = this.currentMistnost.getNeighbor(this.nextMistnostName);
        boolean notifyObservers = false; //Pro jistotu vytvarim uz tady, at si s tim garbage collector poradi
        if (nextMistnost != null) {
            //TODO: Otestovat tento if, protoze si myslim, ze nebude fungovat tak, jak chci
            if (Objects.equals(this.currentMistnost.getName(), "venku") && Objects.equals(nextMistnost.getName(), "chodba")) {
                notifyObservers = false;
            } else if (Objects.equals(nextMistnost.getName(), "chodba")) {
                notifyObservers = true;
            }
            this.currentMistnost = nextMistnost;
            System.out.println(" do " + this.currentMistnost.getName());
            if (notifyObservers) {
                this.observable.notifyObservers("chodba");
            }
            return " do " + this.currentMistnost.getName();
        } else {
            return "Tato místnost neexistuje nebo tam nemůžete jít.";
        }
    }

    public String getNextMistnostName() {
        return nextMistnostName;
    }

    @Override
    public void setter(String nextMistnostName) {
        this.nextMistnostName = nextMistnostName;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
