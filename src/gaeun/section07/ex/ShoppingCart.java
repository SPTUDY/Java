package gaeun.section07.ex;

import java.util.ArrayList;

public class ShoppingCart {
    private Item[] items = new Item[10];
    private int itemCount = 0;

    public void addItem(Item item) {
        if (itemCount  >= 10) {
            System.out.println("장바구니가 가득 찼습니다.");
            return;
        }
        items[itemCount] = item;
        itemCount++;
    }

    public void displayItems() {
        int totalPrice = 0;
        System.out.println("장바구니 상품 출력");
        for (Item item : items ) {
            if (item == null) break;
            System.out.println("상품:" + item.getName() + ", 합계:" + item.getTotalPrice());
            totalPrice += item.getTotalPrice();
        }
        System.out.println("전체 가격 합:" + calculateTotalPrice());
    }

    private int calculateTotalPrice() {
        int totalPrice = 0;
        for (Item item : items) {
            if (item == null) break;
            totalPrice += item.getTotalPrice();
        }
        return totalPrice;
    }
}
