import command.konzole.Konzole;
import singleton.Svet;
import singleton.SvetLoader;

/**
 * Hlavní třída programu, která spouští hru.
 */
public class Main {
    public static void main(String[] args) {
        Konzole konzole = new Konzole();
        konzole.start();
    }
}
