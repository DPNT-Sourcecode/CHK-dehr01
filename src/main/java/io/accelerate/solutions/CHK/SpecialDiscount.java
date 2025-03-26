package io.accelerate.solutions.CHK;

public class SpecialDiscount {
    private char[] requiredItems;
    private int requiredAmount;
    private int price;

    // Constructor
    public SpecialDiscount(char[] requiredItems, int requiredAmount, int price) {
        this.requiredItems = requiredItems;
        this.requiredAmount = requiredAmount;
        this.price = price;
    }

    // Getter for requiredItems
    public char[] getRequiredItems() {
        return requiredItems;
    }

    // Getter for requiredAmount
    public int getRequiredAmount() {
        return requiredAmount;
    }

    // Getter for price
    public int getPrice() {
        return price;
    }
}
