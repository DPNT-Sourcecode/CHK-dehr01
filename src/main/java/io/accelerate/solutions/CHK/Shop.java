package io.accelerate.solutions.CHK;

import java.sql.Array;
import java.util.*;

public class Shop {
    List<ShopItem> items;

    SpecialDiscount sd;

    public Shop() {
        items = new ArrayList<>();
    };

    public Shop addItem(ShopItem item) {
        items.add(item);
        return this;
    }

    public Shop addSpecialDiscount(char[] includedItems, int requiredAmount, int price) {
        sd = new SpecialDiscount(includedItems, requiredAmount, price);
        return this;
    }

    public int calculatePrice(HashMap<Character, Integer> frequencies) {

        int total = 0;

        // calculate the special discount
        int totalSpecialDiscountFrequencies = 0;
        for (char item : sd.getRequiredItems()) {
            totalSpecialDiscountFrequencies += frequencies.getOrDefault(item, 0);
        }
        total += sd.getPrice() * totalSpecialDiscountFrequencies / sd.getRequiredAmount();
        System.out.println(total);

        // handle the remaining unused special discount items
        int remainingSpecialDiscountItems = totalSpecialDiscountFrequencies % sd.getRequiredAmount();
        System.out.println(remainingSpecialDiscountItems);
        if (remainingSpecialDiscountItems > 0) {
            // we want to choose the cheapest speical-discount-items to not include in the discount
            HashMap<Character, Integer> cheapestSpeicalDiscountPrice = new HashMap<>();
            for (char item : sd.getRequiredItems()) {
                for (ShopItem shopItem : this.items) {
                    if (item == shopItem.getName()) {
                        cheapestSpeicalDiscountPrice.put(item, shopItem.getUnitPrice());
                    }
                }
            }

            // sort the special discount items in decreasing order of price
            List<Map.Entry<Character, Integer>> entrylist = new ArrayList<>(cheapestSpeicalDiscountPrice.entrySet());
            entrylist.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
            for (Map.Entry<Character, Integer> entry : entrylist) {
                int currentAmount = frequencies.getOrDefault(entry.getKey(), 0);
                if (currentAmount > 0) {
                   if (currentAmount < remainingSpecialDiscountItems) {
                       remainingSpecialDiscountItems -= currentAmount;
                       frequencies.put(entry.getKey(), 0);
                   } else {
                       frequencies.put(entry.getKey(), currentAmount - remainingSpecialDiscountItems);
                       break;
                   }
                }
            }
        }


        // consider if we have any freebies
        List<Freebies> freebies = new ArrayList<>();
        for (ShopItem item : items) {
            freebies.addAll(item.getFreebies(frequencies));
        }

        // if we do, remove the free amount from our frequencies map
        for (Freebies f : freebies) {
            int existingItems = frequencies.getOrDefault(f.getFreeItemType(), 0);
            int itemsAfterRemovingFree = Math.max(0, existingItems - f.getNumberOfFreeItems());
            frequencies.put(f.getFreeItemType(), itemsAfterRemovingFree);
        }

        // sum how much each of the non-free items now cost
        for (ShopItem item : items) {
            total += item.calculatePrice(frequencies.getOrDefault(item.getName(), 0));
        }
        return total;
    }
}





