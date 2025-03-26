package io.accelerate.solutions.CHK;

import io.accelerate.runner.SolutionNotImplementedException;

import java.util.HashMap;

public class CheckoutSolution {
    public Integer checkout(String skus) {
        int totalPrice = 0;

        // count how many of each item we are buying
        HashMap<Character, Integer> frequencies = new HashMap<>();
        for (char item : skus.toCharArray()) {
            int previousFreq = frequencies.getOrDefault(item, 0);
            frequencies.put(item, previousFreq + 1);
        }

        // sum over each item type
        for (char item : frequencies.keySet()) {
            switch (item) {
                case 'A':
                    
                    totalPrice += 50 * frequencies.get(item);
                    break;
                case 'B':
                    totalPrice += 30 * frequencies.get(item);
                    break;
                case 'C':
                    totalPrice += 20 * frequencies.get(item);
                    break;
                case 'D':
                    totalPrice += 15 * frequencies.get(item);
                    break;
            }
        }

        return totalPrice;
    }
}

