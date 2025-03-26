package io.accelerate.solutions.CHK;

import java.util.HashMap;

public class CheckoutSolution {

    public Integer calculateFpricing(int n) {
        if (n <= 0 ) {return 0; }
        if (n < 3) { return 10 * n; }
        n -= 3; // pay 20 for the first 3
        return 20 + 10 * ((n / 2) + (n % 2));
    }

    public Integer checkout(String skus) {

        // check string is valid
        if (!skus.matches("[A-Z]*")) {
            return -1;
        }

        // count how many of each item we are buying
        HashMap<Character, Integer> freq = new HashMap<>();
        for (char item : skus.toCharArray()) {
            int previousFreq = freq.getOrDefault(item, 0);
            freq.put(item, previousFreq + 1);
        }

        Shop shop = new Shop()
                .addItem(
                        new ShopItem('A', 50)
                                .addDiscount(3, 130)
                                .addDiscount(5, 200)
                )
                .addItem(
                        new ShopItem('B', 30)
                                .addDiscount(2, 45)
                )
                .addItem(new ShopItem('C', 20))
                .addItem(new ShopItem('D', 15))
                .addItem(
                        new ShopItem('E', 40)
                                .addBuyXgetYfree(2, 1, 'B')
                )
                .addItem(
                        new ShopItem('F', 10)
                                .addBuyXgetYfree(2, 1, 'F')
                )
                .addItem(new ShopItem('G', 20))
                .addItem(
                        new ShopItem('H', 10)
                                .addDiscount(5, 45)
                                .addDiscount(10, 80)
                )
                .addItem(new ShopItem('I', 35))
                .addItem(new ShopItem('J', 60))
                .addItem(
                        new ShopItem('K', 80)
                                .addDiscount(2, 150)
                )
                .addItem(new ShopItem('L', 90))
                .addItem(new ShopItem('M', 15))
                .addItem(
                        new ShopItem('N', 40)
                                .addBuyXgetYfree(3, 1, 'M')
                )
                .addItem(new ShopItem('O', 10))
                .addItem(
                        new ShopItem('P', 50)
                                .addDiscount(5, 200)
                )
                .addItem(
                        new ShopItem('Q', 30)
                                .addDiscount(3, 80)
                )
                .addItem(
                        new ShopItem('R', 50)
                                .addBuyXgetYfree(3, 1, 'Q')
                )
                .addItem(new ShopItem('S', 30))
                .addItem(new ShopItem('T', 20))
                .addItem(
                        new ShopItem('U', 40)
                                .addBuyXgetYfree(3, 1, 'U')
                )
                .addItem(
                        new ShopItem('V', 50)
                                .addDiscount(2, 90)
                                .addDiscount(3, 130)
                )
                .addItem(new ShopItem('W', 20))
                .addItem(new ShopItem('X', 90))
                .addItem(new ShopItem('Y', 10))
                .addItem(new ShopItem('Z', 50));

        return shop.calculatePrice(freq);
    }
}




