package io.accelerate.solutions.CHK;

import io.accelerate.runner.SolutionNotImplementedException;

import java.util.HashMap;

public class CheckoutSolution {

    /**
     * @param n number of B's purchased
     * @return cost of n B's with discounts applied
     */
    public Integer calculateBpricing(int n) {
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
        // B prices
        if (freq.containsKey('B')) {
            totalPrice += calculateBpricing(freq.get('B'));
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
                    totalPrice += 20 * n;
                    break;
                case 'D':
                    totalPrice += 15 * n;
                    break;
                case 'E':
                    totalPrice += 40 * n;
                    freeBcount = n / 2;
            }
//
//            if (freq.get('B') - freeBcount > 0) {
//                totalPrice -=
//            }
        }

        return totalPrice;
    }
}



