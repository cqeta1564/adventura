package item;

public class ItemFactory {

    public static Item createItem(String type) {
        switch (type) {
            case "kontraband":
                return new Kontraband("Kontraband", 150);
            case "promitacka":
                return new Kontraband("Promitacka", 500);
            case "pocitac":
                return new Kontraband("Pocitac", 1000);
            case "monitor":
                return new Kontraband("Monitor", 400);
            default:
                return null;
        }
    }
}
