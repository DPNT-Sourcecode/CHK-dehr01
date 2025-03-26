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

    public Integer checkout(String skus) {

        // check string is valid
        if (!skus.matches("[ABCDE]*")) {
            return -1;
        }

        int totalPrice = 0;

        // count how many of each item we are buying
        HashMap<Character, Integer> freq = new HashMap<>();
        for (char item : skus.toCharArray()) {
            int previousFreq = freq.getOrDefault(item, 0);
            freq.put(item, previousFreq + 1);
        }

        // sum over some items
        if (freq.containsKey('B')) {
            int numberOfBs = freq.get('B');
            int numberOfFreeBs = freq.getOrDefault('E', 0) / 2;
            totalPrice += calculateBpricing(numberOfBs - numberOfFreeBs);
        }

        totalPrice += calculatePricing(freq.getOrDefault('C', 0), 20);
        totalPrice += calculatePricing(freq.getOrDefault('D', 0), 15);
        totalPrice += calculatePricing(freq.getOrDefault('E', 0), 40);
        totalPrice += calculateApricing(freq.getOrDefault('A', 0));


        return totalPrice;
    }
}


