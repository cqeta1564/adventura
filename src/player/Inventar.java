package player;

import item.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Inventar {
    private List<Item> items = new ArrayList<>();
    private int penize = 100;

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(String item, int pocet) {
        for (int i = 0; i < pocet; i++) {
            for (int j = 0; j < items.size(); j++) {
                if (Objects.equals(items.get(j).getNazev(), item)) {
                    items.remove(j);
                    j = items.size() - 1; //ingnorovat zbytek smycky, aby se item nevymazal vickrat, nez ma
                }
            }
        }
    }

    public Item getItem(int index) {
        return items.get(index);
    }

    //TODO: Udelat smysluplnejsi vypis
    public String showItems() {
        StringBuilder sb = new StringBuilder();
        for (Item item : items) {
            sb.append(item.getNazev()).append(" - ").append(item.getCena()).append(" Kč");
        }
        return sb.toString();
    }

    public int getSize() {
        return items.size();
    }

    public int pocetItemu(String nazev) {
        int pocet = 0;
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i).getNazev().equals(nazev)) {
                pocet++;
            }
        }
        return pocet;
    }

    public boolean zkontrolovatInventar() {
        System.out.println("Probíhá kontrola inventáře...");
        if (!this.items.isEmpty()){
            this.items.subList(1, this.items.size() + 1).clear(); //vygenerovano z Idea, nevim jak to funguje
            return true;
        }
        return false;
    }

    public int getPenize() {
        return penize;
    }

    public void addPenize(int penize) {
        this.penize = penize;
    }
}
