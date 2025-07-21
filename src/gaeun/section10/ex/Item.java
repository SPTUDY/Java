package gaeun.section10.ex;

public class Item {
    private int price;
    private String name;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void print() {
        System.out.println("이름: "+ name+ ", 가격: " + price);
    }

    public int getPrice() {
        return this.price;
    }
}
