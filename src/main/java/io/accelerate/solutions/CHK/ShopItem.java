package io.accelerate.solutions.CHK;

public class ShopItem {
    private int unitPrice;
    private char name;

    public ShopItem(char name, int unitPrice) {
        name = name;
        unitPrice = unitPrice;
    }

   public Character getName() {
        return name;
   }

    public int calculatePrice(int count) {
        if (count <= 0) { return 0; }
        return count * unitPrice;
    }
}

