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
            System.out.println(item.getNazev() + " - " + item.getCena() + " Kč");
        }
    }

    //TODO: Dopsat metodu pro kontrolu kontrabandu v inventari a jeho nasledne mazani, popripade prida quest na navstevu reditelny
    public void zkontrolovatInventar() {

    }
}
