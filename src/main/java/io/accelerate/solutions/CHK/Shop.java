package io.accelerate.solutions.CHK;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Shop {
    List<ShopItem> items;

    public Shop() {
        items = new ArrayList<>();
    };

    public Shop addItem(ShopItem item) {
        items.add(item);
        return this;
    }

    public int calculatePrice(HashMap<Character, Integer> frequencies) {
        int total = 0;
        for (ShopItem item : items) {
            total += item.calculatePrice(frequencies.getOrDefault(item.getName(), 0));
        }
        return total;
    }
}


