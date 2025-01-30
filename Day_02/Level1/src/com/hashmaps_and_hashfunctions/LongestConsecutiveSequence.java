//LongestConsecutiveSequence
//Problem: Given an unsorted array, find the length of the longest consecutive elements sequence.
//Hint: Use a hash map to store elements and check for consecutive elements efficiently
package com.hashmaps_and_hashfunctions;

import java.util.HashMap;

public class LongestConsecutiveSequence {
    static int longestConsecutiveSubsequence(int arr[]) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        // Store elements in HashMap
        for (int i = 0; i < arr.length; i++) {
            hashMap.put(arr[i], i);
        }

        int cnt = 0;
        int lcs = 0;

        for (int i = 0; i < arr.length; i++) {
            // Start new sequence if no previous number exists
            if (hashMap.containsKey(arr[i]) && !hashMap.containsKey(arr[i] - 1)) {
                int curr = arr[i];
                cnt = 0;

                // Count consecutive numbers
                while (hashMap.containsKey(curr)) {
                    hashMap.remove(curr);
                    curr++;
                    cnt++;
                }

                // Update longest sequence
                lcs = Math.max(lcs, cnt);
            }
        }

        return lcs; // Return result
    }


    public static void main(String[] args) {


        int[] arr2 = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutiveSubsequence(arr2));

        int[] arr3 = {1, 2, 3, 4, 5};
        System.out.println(longestConsecutiveSubsequence(arr3));

        int[] arr4 = {7};
        System.out.println(longestConsecutiveSubsequence(arr4));

        int[] arr5 = {1, 2, 2, 3, 4};
        System.out.println(longestConsecutiveSubsequence(arr5));

        int[] arr6 = {-1, 0, 1, 2, -2, -3};
        System.out.println(longestConsecutiveSubsequence(arr6));

        int[] arr7 = {10, 20, 30, 40, 50};
        System.out.println(longestConsecutiveSubsequence(arr7));

        int[] arr8 = {9, 1, 4, 7, 3, -1, 0, 5, 8, -2, 6};
        System.out.println(longestConsecutiveSubsequence(arr8));

        int[] arr9 = {5, 2, 99, 3, 4, 1, 100, 101, 6};
        System.out.println(longestConsecutiveSubsequence(arr9));
    }
}
