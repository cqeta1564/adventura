package command;

import observer.Observable;
import player.Hrac;
import singleton.Mistnost;

import java.util.Scanner;

// TODO: Srovnat diakritiku
public class Napoveda extends Command {
    @Override
    public String execute(Hrac hrac, Mistnost currentMistnost, Scanner scanner, Observable observable) {
        switch (currentMistnost.getName()){
            case "venku":
                return "Jsi venku. Můžeš jít do skolt nebo za skolu.";
            case "chodba":
                return "Jsi v chodbě. Můžeš jít do kmenove ucebny, fyzikalni ucebny, pocitacove ucebny, dilen, reitelny, zachod nebo ven.";
            case "za skolou":
                return "Jsi za školou. Můžeš jít ven.";
            case "kmenova ucebna":
                return "Jsi v kmenové učebně. Můžeš jít na chodbu.";
            case "fyzikalni ucebna":
                return "Jsi ve fyzikální učebně. Můžeš jít na chodbu, nebo muzes krast.";
            case "pocitacova ucebna":
                return "Jsi v počítačové učebně. Můžeš jít na chodbu, nebo muzes krast.";
            case "dilny":
                return "Jsi v dílnách. Můžeš jít na chodbu.";
            case "aula":
                return "Jsi v aule. Můžeš jít na chodbu.";
            case "reditelna":
                return "Jsi v ředitelně. Můžeš jít na chodbu.";
            case "zachody":
                return "Jsi na záchodech. Můžeš jít na chodbu nebo zacit prodavat kontraband.";
            default:
                return "Nemůžu ti poradit, dokazal jsi se mi stratit ve svete co jsem sam vymyslel.";
        }
    }

    @Override
    public Mistnost move(Mistnost currentMistnost, String nextMistnostName, Observable observable) {
        return currentMistnost;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
