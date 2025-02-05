package com.dsa.searchingalgorithm.challengeproblem;

import java.util.LinkedList;
import java.util.List;

public class LinearSearch {
    List<Integer> list = new LinkedList<Integer>();

    // Finds the missing positive number in the list
    public static int findMissingNumber(List<Integer> list) {
        int n = list.size();

        // Mark out-of-range or non-positive numbers as irrelevant (n+1)
        for (int i = 0; i < n; i++) {
            if (list.get(i) <= 0 || list.get(i) > n) {
                list.set(i, n + 1);  // Mark as out of range
            }
        }

        // Mark elements that exist in the list
        for (int i = 0; i < n; i++) {
            int num = Math.abs(list.get(i));  // Get absolute value
            if (num <= n && list.get(num - 1) > 0) {
                list.set(num - 1, -list.get(num - 1));  // Mark as visited
            }
        }

        // Find the first missing positive number
        for (int i = 0; i < n; i++) {
            if (list.get(i) > 0) {
                return i + 1;  // Return the missing number
            }
        }

        return n + 1;  // Return n+1 if no missing number
    }
}
