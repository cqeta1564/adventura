package player;

import item.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Třída Inventar reprezentuje hráčův inventář s předměty a penězi.
 */
public class Inventar {
    private List<Item> items = new ArrayList<>();
    private int penize = 100;

    /**
     * Přidá předmět do inventáře.
     *
     * @param item Předmět k přidání.
     */
    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * Odstraní z inventáře určitý počet předmětů podle názvu.
     *
     * @param item  Název předmětu k odstranění.
     * @param pocet Počet kusů k odstranění.
     */
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

    /**
     * Vrátí položku na daném indexu v inventáři.
     *
     * @param index Index položky.
     * @return Položka v inventáři.
     */
    public Item getItem(int index) {
        return items.get(index);
    }

    //TODO: Udelat smysluplnejsi vypis
    /**
     * Vrátí textovou reprezentaci předmětů v inventáři.
     *
     * @return Seznam předmětů jako řetězec.
     */
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

    /**
     * Zkontroluje inventář a vyprázdní ho, pokud obsahuje zakázané předměty.
     *
     * @return `true`, pokud inventář obsahoval zakázané předměty.
     */
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

    /**
     * Přidá hráči peníze.
     *
     * @param penize Počet přidaných peněz.
     */
    public void addPenize(int penize) {
        this.penize = penize;
    }
}
