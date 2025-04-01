package item;

/**
 * Rozhraní reprezentující herní předmět.
 */
public interface Item {
    /**
     * Vrátí název předmětu.
     *
     * @return Název předmětu.
     */
    String getNazev();

    /**
     * Vrátí cenu předmětu.
     *
     * @return Cena předmětu.
     */
    int getCena();
}
