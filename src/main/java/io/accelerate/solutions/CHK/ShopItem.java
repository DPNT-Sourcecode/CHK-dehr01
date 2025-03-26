package io.accelerate.solutions.CHK;

import java.util.Collection;
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

        int totalPrice = 0;

        if (count <= 0) { return totalPrice; }

        // sort discounts so we consider them highest frequency first
        List<Map.Entry<Integer, Integer>> sortedDiscounts = discounts
                .stream()
                .sorted((a, b) -> a.getKey().compareTo(b.getKey()))
                .collect(Collectors.toList());
        // apply discounts
        for (Integer frequency : discounts.keySet()) {
            int discountPrice = discounts.get(frequency);
            int fullSets = count / frequency;
            totalPrice += fullSets * discountPrice;
            count %= frequency;
        }

        totalPrice += count * unitPrice;
        return totalPrice;
    }
}

