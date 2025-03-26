package io.accelerate.solutions.CHK;

import io.accelerate.runner.SolutionNotImplementedException;

import java.util.HashMap;

public class CheckoutSolution {
    public Integer checkout(String skus) {
        int totalPrice = 0;

        // count how many of each item we are buying
        HashMap<Character, Integer> freq = new HashMap<>();
        for (char item : skus.toCharArray()) {
            int previousFreq = freq.getOrDefault(item, 0);
            freq.put(item, previousFreq + 1);
        }
        System.out.println(freq);
        // sum over each item type
        for (char item : freq.keySet()) {
            switch (item) {
                case 'A':
                    totalPrice += 50 * (freq.get(item) % 3); // full price remainder
                    totalPrice += 130 * (freq.get(item) / 3); // discounts
                    break;
                case 'B':
                    totalPrice += 30 * (freq.get(item) % 2); // full price remainder
                    totalPrice += 45 * (freq.get(item) / 2); // discounts
                    break;
                case 'C':
                    totalPrice += 20 * freq.get(item);
                    break;
                case 'D':
                    totalPrice += 15 * freq.get(item);
                    break;
            }
        }

        return totalPrice;
    }
}





