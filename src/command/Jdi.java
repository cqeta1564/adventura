package command;
import singleton.Mistnost;

public class Jdi extends Command {
    @Override
    public String execute() {
        return "provadim prikaz jdi... volam metodu move()";
    }

    @Override
    public String move(Mistnost currentMistnost) { //Zde se bude provadet pohyb
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
