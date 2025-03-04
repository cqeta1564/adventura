import command.konzole.Konzole;
import singleton.Mistnost;
import singleton.Svet;
import singleton.SvetLoader;

/**
 * Hlavní třída hry, která inicializuje svět a spouští konzoli.
 */
public class Hrac {
    private Svet svet;
    private Mistnost currentMistnost;
    private Konzole konzole;

    /**
     * Konstruktor hry, načítá svět a spouští konzoli.
     */
    public Hrac() {

    }

    public Mistnost getCurrentMistnost() {
        return currentMistnost;
    }

    public void setCurrentMistnost(Mistnost currentMistnost) {
        this.currentMistnost = currentMistnost;
    }
}
