package item;

public class Kontraband implements Item {
    private String nazev;
    private int cena;

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
