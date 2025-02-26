import java.util.HashMap;
import java.util.Map;

public class Room {
    private final String name;
    private final Map<String, Room> neighbors;

    public Room(String name) {
        this.name = name;
        this.neighbors = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void addNeighbor(String roomName, Room room) {
        neighbors.put(roomName, room);
    }

    public Room getNeighbor(String roomName) {
        return neighbors.get(roomName);
    }

    public Map<String, Room> getNeighbors() {
        return neighbors;
    }
}
