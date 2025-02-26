import java.util.HashMap;
import java.util.Map;

public class World {
    private static World instance;
    private final Map<String, Room> rooms;

    private World() {
        rooms = new HashMap<>();
    }

    public static World getInstance() {
        if (instance == null) {
            instance = new World();
        }
        return instance;
    }

    public void addRoom(Room room) {
        rooms.put(room.getName(), room);
    }

    public Room getRoom(String name) {
        return rooms.get(name);
    }
}
