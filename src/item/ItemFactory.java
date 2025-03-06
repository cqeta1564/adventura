package item;

public class ItemFactory {
    public static Item createItem(String type) {
        switch (type) {
            case "cigarety":
                return new Kontraband("Cigarety", 100);
            case "alkohol":
                return new Kontraband("Alkohol", 200);
            case "drogy":
                return new Kontraband("Drogy", 500);
            default:
                return null;
        }
    }
}
