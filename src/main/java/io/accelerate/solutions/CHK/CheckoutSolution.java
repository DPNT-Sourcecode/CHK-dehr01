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
        int totalPrice = 0;

        Shop shop = new Shop();

        shop
                .addItem(new ShopItem('C', 20))
                .addItem(new ShopItem('E', 40))
                .addItem(new ShopItem('D', 15));

        // A
        shop.addItem(
                new ShopItem('A', 50)
                        .addDiscount(3, 130)
                        .addDiscount(5, 200)
        );

        totalPrice += shop.calculatePrice(freq);

        // add up the prices for each item
        totalPrice += calculateBpricing(
                freq.getOrDefault('B', 0) -
                        (freq.getOrDefault('E', 0) / 2)
        );
        totalPrice += calculateFpricing(freq.getOrDefault('F', 0));


        return totalPrice;
    }
}


