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

        // sum over each item type
        for (char item : freq.keySet()) {
            switch (item) {
                case 'A':
                    totalPrice += 50 * Math.floorMod(freq.get(item), 3);
                    System.out.println(totalPrice + " " + Math.floorMod(freq.get(item), 3));
                    totalPrice += 50 * freq.get(item) % 3;
                    System.out.println(totalPrice + " " + (freq.get(item) % 3));
                    break;
                case 'B':
                    totalPrice += 45 * Math.floorMod(freq.get(item), 2);
                    totalPrice += 30 * (freq.get(item) % 2);
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



