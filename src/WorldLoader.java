import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WorldLoader {
    public static void loadWorld(String filePath) {
        World world = World.getInstance();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String roomName = parts[0];

                Room room = world.getRoom(roomName);
                if (room == null) {
                    room = new Room(roomName);
                    world.addRoom(room);
                }

                for (int i = 1; i < parts.length; i++) {
                    String neighborName = parts[i];
                    Room neighbor = world.getRoom(neighborName);
                    if (neighbor == null) {
                        neighbor = new Room(neighborName);
                        world.addRoom(neighbor);
                    }
                    room.addNeighbor(neighborName, neighbor);
                    neighbor.addNeighbor(roomName, room); // Obojsměrné propojení
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
