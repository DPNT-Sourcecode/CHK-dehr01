package io.accelerate.solutions.CHK;

import java.sql.Array;
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
        System.out.println(frequencies);

        // consider if we have any freebies
        List<Freebies> freebies = new ArrayList<>();
        for (ShopItem item : items) {
            freebies.addAll(item.getFreebies(frequencies));
        }
        System.out.println(freebies);

        // if we do, remove the free amount from our frequencies map
        for (Freebies f : freebies) {
            int existingItems = frequencies.getOrDefault(f.getFreeItemType(), 0);
            int itemsAfterRemovingFree = Math.max(0, existingItems - f.getNumberOfFreeItems());
            frequencies.put(f.getFreeItemType(), itemsAfterRemovingFree);
        }

        // sum how much each of the non-free items now cost
        int total = 0;
        for (ShopItem item : items) {
            total += item.calculatePrice(frequencies.getOrDefault(item.getName(), 0));
        }
        return total;
    }
}

