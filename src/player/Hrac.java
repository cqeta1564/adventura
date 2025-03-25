package player;

public class Hrac {
    private Inventar inventar;

    private boolean questReditelna;

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
