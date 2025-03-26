package io.accelerate.solutions.CHK;

public class Freebies {
    private final char givingItemType;
    private final char itemType;
    private final int freeQuantity;
    private final int minimumAmount;


    public Freebies(char givingItemType, char itemType, int freeQuantity, int minimumAmount) {
        this.givingItemType = givingItemType;
        this.itemType = itemType;
        this.freeQuantity = freeQuantity;
        this.minimumAmount = minimumAmount;
    }

    public char getItemType() { return itemType; }

    public char getGivingItemType() { return givingItemType; }

    public int getFreeQuantity() {
        return freeQuantity;
    }

    public int getMinimumAmount() { return minimumAmount; }

    @Override
    public String toString() {
        return String.format("Freebies[givignItemType='%c', itemType='%c', freeQuantity=%d, minimumAmount=%d]", givingItemType, itemType, freeQuantity, minimumAmount);
    }
}




