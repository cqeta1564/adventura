package singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * Reprezentuje místnost ve světě hry.
 */
public class Mistnost {
    private final String name;
    private final Map<String, Mistnost> neighbors;

    /**
     * Vytvoří novou místnost se zadaným názvem.
     * @param name Název místnosti
     */
    public Mistnost(String name) {
        this.name = name;
        this.neighbors = new HashMap<>();
    }

    /**
     * Vrátí název místnosti.
     * @return Název místnosti
     */
    public String getName() {
        return name;
    }

    /**
     * Přidá sousední místnost.
     * @param roomName Název sousední místnosti
     * @param mistnost Instance sousední místnosti
     */
    public void addNeighbor(String roomName, Mistnost mistnost) {
        neighbors.put(roomName, mistnost);
    }

    /**
     * Vrátí sousední místnost podle názvu.
     * @param roomName Název sousední místnosti
     * @return Instance sousední místnosti nebo null, pokud neexistuje
     */
    public Mistnost getNeighbor(String roomName) {
        return neighbors.get(roomName);
    }

    /**
     * Vrátí mapu sousedních místností.
     * @return Mapa sousedních místností
     */
    public Map<String, Mistnost> getNeighbors() {
        return neighbors;
    }
}
