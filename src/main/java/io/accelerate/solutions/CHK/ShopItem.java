package io.accelerate.solutions.CHK;

import java.util.HashMap;

public class ShopItem {
    private final int unitPrice;
    private final char name;
    private HashMap<Integer, Integer> discounts; // frequency -> resulting price

    public ShopItem(char name, int unitPrice) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.discounts = new HashMap<>();
    }

    public ShopItem addDiscount(int frequency, int resulting_price) {
        discounts.put(frequency, resulting_price);
        return this;
    }

    public char getName() {
        return name;
    }

    public int calculatePrice(int count) {
        if (count <= 0) { return 0; }
        return count * unitPrice;
    }
}



