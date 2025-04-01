package player;

/**
 * Třída Hrac reprezentuje hráče ve hře.
 * Obsahuje hráčův inventář a stav úkolu s ředitelem.
 */
public class Hrac {
    private Inventar inventar;

    private boolean questReditelna;

    /**
     * Vytvoří nového hráče s prázdným inventářem a bez aktivního úkolu s ředitelem.
     */
    public Hrac() {
        this.inventar = new Inventar();
        this.questReditelna = false;
    }

    public Inventar getInventar() {
        return inventar;
    }

    public void setInventar(Inventar inventar) {
        this.inventar = inventar;
    }

    public boolean isQuestReditelna() {
        return questReditelna;
    }

    public void setQuestReditelna(boolean questReditelna) {
        this.questReditelna = questReditelna;
    }
}
