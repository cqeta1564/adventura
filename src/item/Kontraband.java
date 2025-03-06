package item;

public class Kontraband implements Item {
    private String name;
    private int price;

    public Kontraband(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }
}
