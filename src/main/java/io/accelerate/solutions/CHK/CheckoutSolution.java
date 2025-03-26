package io.accelerate.solutions.CHK;

import java.util.HashMap;

public class CheckoutSolution {

    /**
     * @param n number of B's purchased
     * @return cost of n B's with discounts applied
     */
    public Integer calculateBpricing(int n) {
        if (n <= 0 ) {return 0;}
        int price = 0;
        price += 30 * (n % 2); // full price remainder
        price += 45 * (n / 2); // discounts
        return price;
    }

    public Integer calculateFpricing(int n) {
        if (n <= 0 ) {return 0; }
        if (n < 3) { return 10 * n; }
        n -= 3; // pay 20 for the first 3
        return 20 + 10 * ((n / 2) + (n % 2));
    }

    public Integer checkout(String skus) {

        // check string is valid
        if (!skus.matches("[ABCDEF]*")) {
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
                );


        return shop.calculatePrice(freq);
    }
}

