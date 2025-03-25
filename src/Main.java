import command.konzole.Konzole;

/**
 * Hlavní třída programu, která spouští hru.
 *
 * Tato třída inicializuje konzoli a spustí hru, která čeká na uživatelský vstup
 * a vykonává příkazy podle zadaných parametrů.
 */
public class Main {
    /**
     * Hlavní metoda programu, která spouští hru.
     *
     * @param args Argumenty příkazového řádku (nevyužíváno)
     */
    public static void main(String[] args) {
        Konzole konzole = new Konzole();
        konzole.start();
    }
}
