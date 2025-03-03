import java.util.HashMap;
import java.util.Map;

public class Mistnost {
    private final String name;
    private final Map<String, Mistnost> neighbors;

    public Mistnost(String name) {
        this.name = name;
        this.neighbors = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void addNeighbor(String roomName, Mistnost mistnost) {
        neighbors.put(roomName, mistnost);
    }

    public Mistnost getNeighbor(String roomName) {
        return neighbors.get(roomName);
    }

    public Map<String, Mistnost> getNeighbors() {
        return neighbors;
    }
}
