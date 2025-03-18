package player;

import item.Item;
import java.util.ArrayList;
import java.util.List;

public class Inventar {
    private List<Item> items = new ArrayList<>();
    private int penize = 100;

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public Item getItem(int index){
        return items.get(index);
    }

    public String showItems() {
        StringBuilder sb = new StringBuilder();
        for (Item item : items) {
            sb.append(item.getNazev()).append(" - ").append(item.getCena()).append(" Kč");
        }
        return sb.toString();
    }

    public int getSize(){
        return items.size();
    }

    //TODO: Dopsat metodu pro kontrolu kontrabandu v inventari a jeho nasledne mazani, popripade prida quest na navstevu reditelny
    public void zkontrolovatInventar() {

    }

    public int getPenize() {
        return penize;
    }

    public void addPenize(int penize) {
        this.penize = penize;
    }
}
