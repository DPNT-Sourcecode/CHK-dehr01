package io.accelerate.solutions.CHK;

public class Freebies {

    private final char requiredItemType;
    private final int requiredItemsNeeded;
    private final char freeItemType;
    private final int numberOfFreeItems;


    public Freebies(char requiredItemType, int requiredItemsNeeded,char freeItemType, int numberOfFreeItems) {
        this.requiredItemType = requiredItemType;
        this.requiredItemsNeeded = requiredItemsNeeded;
        this.freeItemType = freeItemType;
        this.numberOfFreeItems = numberOfFreeItems;
    }


}

