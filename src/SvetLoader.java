import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SvetLoader {
    public static void loadWorld() {
        Svet svet = Svet.getInstance();

        try (BufferedReader reader = new BufferedReader(new FileReader("res/world.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String roomName = parts[0];

                Mistnost mistnost = svet.getRoom(roomName);
                if (mistnost == null) {
                    mistnost = new Mistnost(roomName);
                    svet.addRoom(mistnost);
                }

                for (int i = 1; i < parts.length; i++) {
                    String neighborName = parts[i];
                    Mistnost neighbor = svet.getRoom(neighborName);
                    if (neighbor == null) {
                        neighbor = new Mistnost(neighborName);
                        svet.addRoom(neighbor);
                    }
                    mistnost.addNeighbor(neighborName, neighbor);
                    neighbor.addNeighbor(roomName, mistnost); // Obojsměrné propojení
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
