package io.accelerate.solutions.CHK;

public class Freebies {

    private final char freeItemType;
    private final int numberOfFreeItems;

    public Freebies(char freeItemType, int numberOfFreeItems) {
        this.freeItemType = freeItemType;
        this.numberOfFreeItems = numberOfFreeItems;
    }

    public char getFreeItemType() {
        return freeItemType;
    }

    public int getNumberOfFreeItems() {
        return numberOfFreeItems;
    }

    // toString method
    @Override
    public String toString() {
        return "Freebies{" +
                " freeItemType=" + freeItemType +
                ", numberOfFreeItems=" + numberOfFreeItems +
                '}';
    }
}


