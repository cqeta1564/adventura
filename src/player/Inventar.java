package player;

import item.Item;
import java.util.ArrayList;
import java.util.List;

public class Inventar {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void showItems() {
        for (Item item : items) {
            System.out.println(item.getName() + " - " + item.getPrice() + " Kč");
        }
    }
}
