package io.accelerate.solutions.CHK;

import java.util.*;
import java.util.stream.Collectors;

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
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .toList();

        // apply discounts
        for (Map.Entry<Integer, Integer> e : sortedDiscounts) {
            int frequency = e.getKey();
            int discountPrice = e.getValue();
            System.out.println(frequency + "- " + discountPrice);
            int fullSets = count / frequency;
            totalPrice += fullSets * discountPrice;
            count %= frequency;
        }

        totalPrice += count * unitPrice;
        return totalPrice;
    }
}


