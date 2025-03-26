package io.accelerate.solutions.CHK;

public class ShopItem {
    private final int unitPrice;
    private final char name;

    public ShopItem(char name, int unitPrice) {
        this.name = name;
        this.unitPrice = unitPrice;
    }

   public char getName() {
        return name;
   }

    public int calculatePrice(int count) {
        if (count <= 0) { return 0; }
        return count * unitPrice;
    }
}


