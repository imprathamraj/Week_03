package com.dsa.searchingalgorithm.challengeproblem;

import java.util.List;
public class BinarySearch {
    public static int findTargetIndex(List<Integer> list, int target){
        int left = 0;
        int right = list.size() - 1;

        // Step 1: Start binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // If target is found at the middle
            if (list.get(mid) == target) {
                return mid;  // Return the index of the target
            }
            // If the target is smaller, search the left half
            else if (list.get(mid) > target) {
                right = mid - 1;
            }
            // If the target is larger, search the right half
            else {
                left = mid + 1;
            }
        }

        // If target is not found
        return -1;
    }
}
