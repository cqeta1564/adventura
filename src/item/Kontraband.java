package item;

/**
 * Třída reprezentující zakázaný předmět (kontraband), který může být držen hráčem.
 * Implementuje rozhraní {@link Item}.
 */
public class Kontraband implements Item {
    private String nazev;
    private int cena;

    /**
     * Vytvoří nový kontraband s daným názvem a cenou.
     *
     * @param nazev Název kontrabandu.
     * @param cena  Cena kontrabandu.
     */
    public Kontraband(String nazev, int cena) {
        this.nazev = nazev;
        this.cena = cena;
    }

    @Override
    public String getNazev() {
        return nazev;
    }

    @Override
    public int getCena() {
        return cena;
    }
}
