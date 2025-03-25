package singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * Singleton třída představující celý svět hry.
 */
public class Svet {
    private static Svet instance;
    private final Map<String, Mistnost> rooms;

    /**
     * Privátní konstruktor pro inicializaci světa.
     */
    private Svet() {
        rooms = new HashMap<>();
    }

    /**
     * Vrací instanci světa (singleton).
     *
     * @return Instance světa
     */
    public static Svet getInstance() {
        if (instance == null) {
            instance = new Svet();
        }
        return instance;
    }

    /**
     * Přidá místnost do světa.
     *
     * @param mistnost Instance místnosti
     */
    public void addRoom(Mistnost mistnost) {
        rooms.put(mistnost.getName(), mistnost);
    }

    /**
     * Vrátí místnost podle názvu.
     *
     * @param name Název místnosti
     * @return Instance místnosti nebo null, pokud neexistuje
     */
    public Mistnost getRoom(String name) {
        return rooms.get(name);
    }
}
