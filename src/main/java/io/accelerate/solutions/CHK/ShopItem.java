package io.accelerate.solutions.CHK;

public class ShopItem {
    int unitPrice;
    char name;

    public ShopItem(char name, int unitPrice) {
        name = name;
        unitPrice = unitPrice;
    }

    public int calculatePrice(int count) {
        if (count <= 0) { return 0; }
        return count * unitPrice;
    }
}
