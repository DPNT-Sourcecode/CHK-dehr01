package io.accelerate.solutions.CHK;

import java.util.*;

public class ShopItem {
    private final int unitPrice;
    private final char name;
    private HashMap<Integer, Integer> discounts; // frequency -> resulting price
    private HashMap<Integer, AbstractMap.SimpleEntry<Character, Integer>> buyXgetYfreeOfZ;

    public ShopItem(char name, int unitPrice) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.discounts = new HashMap<>();
        this.buyXgetYfreeOfZ = new HashMap<>();
    }

    public ShopItem addDiscount(int frequency, int resulting_price) {
        discounts.put(frequency, resulting_price);
        return this;
    }

    public ShopItem addBuyXgetYfree(int buyFrequency, int freeFrequency, char freeItemType) {
        buyXgetYfreeOfZ.put(buyFrequency, new AbstractMap.SimpleEntry<>(freeItemType, freeFrequency));
        return this;
    }

    public List<Freebies> getFreebies(HashMap<Character, Integer> frequencies) {
        List<Freebies> freebiesList = new ArrayList<>();
        for (Map.Entry<Integer, AbstractMap.SimpleEntry<Character, Integer>> e : buyXgetYfreeOfZ.entrySet()) {

            int requiredItemsPerFreeItem = e.getKey();
            char requiredItemType = name;

            int actualRequiredItemCount = frequencies.getOrDefault(name, 0);

            char freeItemType = e.getValue().getKey();
            int freeItemPerRequired = e.getValue().getValue();

            if (requiredItemType != freeItemType) {
                System.out.println(actualRequiredItemCount / freeItemPerRequired);
                freebiesList.add(new Freebies(freeItemType, actualRequiredItemCount / freeItemPerRequired));
                continue;
            }

            // case where the free item is the same as the required item
            int totalFreeitems = 0;
            int remainingItems = actualRequiredItemCount;

            while (remainingItems > requiredItemsPerFreeItem) {
                totalFreeitems += freeItemPerRequired;
                remainingItems -= requiredItemsPerFreeItem;
            }

            if (totalFreeitems > 0) {
                freebiesList.add(new Freebies(freeItemType, totalFreeitems));
            }
        }

        return freebiesList;
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
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .toList();

        // apply discounts
        for (Map.Entry<Integer, Integer> e : sortedDiscounts) {
            int frequency = e.getKey();
            int discountPrice = e.getValue();
            int fullSets = count / frequency;
            totalPrice += fullSets * discountPrice;
            count %= frequency;
        }

        totalPrice += count * unitPrice;
        return totalPrice;
    }
}


