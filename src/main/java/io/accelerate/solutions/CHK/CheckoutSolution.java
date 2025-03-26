package io.accelerate.solutions.CHK;

import io.accelerate.runner.SolutionNotImplementedException;

import java.util.HashMap;

public class CheckoutSolution {

    /**
     *
     * @param n number of the item purchased
     * @param unitPrice price for one item
     * @return the total price
     */
    public Integer calculatePricing(int n,  int unitPrice) {
        if (n <= 0) { return 0; }
        return n * unitPrice;
    }

    public Integer calculateApricing(int n) {
        int totalPrice = 0;
        totalPrice += 200 * (n / 5);
        n %= 5;
        totalPrice += 130 * (n / 3);
        n %= 3;
        totalPrice += 50 * n;
        return totalPrice;
    }

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
        int price = 20; // pay 20 for the first 3
        n -= 3;
        return (int) (10 * Math.ceil(n / 2.0));
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

        // add up the prices for each item
        int totalPrice = 0;
        totalPrice += calculateApricing(freq.getOrDefault('A', 0));
        totalPrice += calculateBpricing(
                freq.getOrDefault('B', 0) -
                        (freq.getOrDefault('E', 0) / 2)
        );
        totalPrice += calculatePricing(freq.getOrDefault('C', 0), 20);
        totalPrice += calculatePricing(freq.getOrDefault('D', 0), 15);
        totalPrice += calculatePricing(freq.getOrDefault('E', 0), 40);
        totalPrice += calculateFpricing(freq.getOrDefault('F', 0));


        return totalPrice;
    }
}







