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
        System.out.println(frequencies + " " + items);
        for (ShopItem item : items) {

            System.out.println("-" + item.getName() + "--" + frequencies.getOrDefault(item.getName(), 0));
            total += item.calculatePrice(frequencies.getOrDefault(item.getName(), 0));
        }
        return total;
    }
}



