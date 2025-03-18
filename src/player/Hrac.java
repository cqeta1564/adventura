package player;

public class Hrac {
    private Inventar inventar;

    public Hrac() {
        inventar = new Inventar();
    }

    public Inventar getInventar() {
        return inventar;
    }

    public void setInventar(Inventar inventar) {
        this.inventar = inventar;
    }
}
