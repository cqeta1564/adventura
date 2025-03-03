import java.util.HashMap;
import java.util.Map;

public class Svet {
    private static Svet instance;
    private final Map<String, Mistnost> rooms;

    private Svet() {
        rooms = new HashMap<>();
    }

    public static Svet getInstance() {
        if (instance == null) {
            instance = new Svet();
        }
        return instance;
    }

    public void addRoom(Mistnost mistnost) {
        rooms.put(mistnost.getName(), mistnost);
    }

    public Mistnost getRoom(String name) {
        return rooms.get(name);
    }
}
