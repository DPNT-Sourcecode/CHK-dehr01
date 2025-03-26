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

        // consider if we have any freebies
        List<Freebies> freebies = new ArrayList<>();
        for (ShopItem item : items) {
            freebies.addAll(item.getFreebies(frequencies.getOrDefault(item.getName(), 0)));
        }

//        int totalItemsBought = frequencies.values().stream().mapToInt(Integer::intValue).sum();

        // if we do, remove the free amount from our frequencies map
        for (Freebies f : freebies) {
            System.out.println(f);
            int existingItems = frequencies.getOrDefault(f.getItemType(), 0);

            // check if we have triggered the discount
            if (frequencies.getOrDefault(f.getGivingItemType(),0) >= f.getMinimumAmount()) {
                // special case where the free item is itself
                if (f.getGivingItemType() != f.getItemType()) {
                    int itemsAfterRemovingFree = Math.max(0, existingItems - f.getFreeQuantity());
                    frequencies.put(f.getItemType(), itemsAfterRemovingFree);
                } else {
                    int itemsAfterRemovingFree = Math.max(f.getMinimumAmount(), existingItems - f.getFreeQuantity());
                    frequencies.put(f.getItemType(), itemsAfterRemovingFree);
                }
            }
        }

        // sum how much each of the non-free items now cost
        int total = 0;
        for (ShopItem item : items) {
            total += item.calculatePrice(frequencies.getOrDefault(item.getName(), 0));
        }
        return total;
    }
}








