package com.hashmaps_and_hashfunctions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class ZeroSumSubArrays {

    // Function to find all subarrays whose sum is zero
    public static List<List<Integer>> findZeroSumSubarrays(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> sumMap = new HashMap<>();

        // To store cumulative sum
        int cumulativeSum = 0;

        // Traverse the array
        for (int i = 0; i < nums.length; i++) {
            // Update the cumulative sum
            cumulativeSum += nums[i];

            // If cumulative sum is 0, then from index 0 to i is a zero sum subarray
            if (cumulativeSum == 0) {
                List<Integer> subarray = new ArrayList<>();
                for (int j = 0; j <= i; j++) {
                    subarray.add(nums[j]);
                }
                result.add(subarray);
            }

            // If cumulative sum exists in the map, then a subarray with zero sum exists
            if (sumMap.containsKey(cumulativeSum)) {
                ArrayList<Integer> list = sumMap.get(cumulativeSum);
                // For each index where cumulativeSum was found
                for (int startIndex : list) {
                    List<Integer> subarray = new ArrayList<>();
                    for (int j = startIndex + 1; j <= i; j++) {
                        subarray.add(nums[j]);
                    }
                    result.add(subarray);
                }
            }

            // Store the current index in the map for the cumulative sum
            sumMap.putIfAbsent(cumulativeSum, new ArrayList<>());
            sumMap.get(cumulativeSum).add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {5,-5,10,9,-6,3,2};

        List<List<Integer>> result = findZeroSumSubarrays(nums);

        // Print all subarrays with zero sum
        for (List<Integer> subarray : result) {
            System.out.println(subarray);
        }
    }
}
