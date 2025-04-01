package item;

/**
 * Tovární třída pro vytváření herních předmětů.
 */
public class ItemFactory {

    /**
     * Vytvoří a vrátí instanci předmětu na základě jeho typu.
     *
     * @param type Typ předmětu, který má být vytvořen (např. "kontraband", "promitacka").
     * @return Instance předmětu odpovídající zadanému typu nebo `null`, pokud typ není rozpoznán.
     */
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
