package io.accelerate.solutions.CHK;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    List<ShopItem> items;

    public Shop() {
        items = new ArrayList<>();
    };

    public ShoppingCart addItem(ShopItem item) {
        items.add(item);
        return this;
    }
}

