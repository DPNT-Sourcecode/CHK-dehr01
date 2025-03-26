package io.accelerate.solutions.CHK;

import io.accelerate.runner.SolutionNotImplementedException;

import java.util.HashMap;

public class CheckoutSolution {


    public Integer calculatePricing(int n,  int unitPrice) {
        return n * unitPrice;
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

        // sum over each item type
        for (char item : freq.keySet()) {
            int n = freq.get(item);
            int freeBcount = 0;
            switch (item) {
                case 'A':
                    totalPrice += 200 * (n / 5);
                    n %= 5;
                    totalPrice += 130 * (n / 3);
                    n %= 3;
                    totalPrice += 50 * n;
                    break;
                case 'C':
                    totalPrice += calculatePricing(n, 20);
                    break;
                case 'D':
                    totalPrice += calculatePricing(n, 15);
                    break;
                case 'E':
                    totalPrice += calculatePricing(n, 40);
            }
//
//            if (freq.get('B') - freeBcount > 0) {
//                totalPrice -=
//            }
        }

        return totalPrice;
    }
}

