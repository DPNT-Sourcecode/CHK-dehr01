package io.accelerate.solutions.CHK;

public class Freebies {
    private final char itemType;
    private final int freeQuantity;

    public Freebies(char itemType, int freeQuantity) {
        this.itemType = itemType;
        this.freeQuantity = freeQuantity;
    }

    public char getItemType() {
        return itemType;
    }

    public int getFreeQuantity() {
        return freeQuantity;
    }
}

