package gaeun.section07.ex;

public class Item {
    private String name;
    private int price;
    private int amount;

    public Item(String name, int price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public int getTotalPrice() {
        return price * amount;
    }
}
