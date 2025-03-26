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

    /**
     *
     * @param n number of this shop item that exist
     * @return the freeby item and how many are free
     */
    public List<Freebies> getFreebies(int n) {
        List<Freebies> freebiesList = new ArrayList<>();

        for (Map.Entry<Integer, AbstractMap.SimpleEntry<Character, Integer>> e : buyXgetYfreeOfZ.entrySet()) {

            AbstractMap.SimpleEntry<Character, Integer> freeInfo = e.getValue();
            char freeItemType = freeInfo.getKey();
            int freeFrequency = freeInfo.getValue();

            int fullSets = n / e.getKey();
            if (fullSets > 0) {
                freebiesList.add(new Freebies(freeItemType, fullSets * freeFrequency));
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
