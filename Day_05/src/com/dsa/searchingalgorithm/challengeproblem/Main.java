package com.dsa.searchingalgorithm.challengeproblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        // Example 1: Find first missing positive integer
        List<Integer> list = new ArrayList<>();
        list.add(3);  // Add elements to the list
        list.add(4);
        list.add(-1);
        list.add(1);

        int firstMissingPositive = LinearSearch.findMissingNumber(list);
        System.out.println("The first missing positive integer is: " + firstMissingPositive);

        // Example 2: Perform binary search for target index in a sorted list
        List<Integer> sortedList = new ArrayList<>();
        sortedList.add(1);  // Add elements to the sorted list
        sortedList.add(3);
        sortedList.add(5);
        sortedList.add(7);
        sortedList.add(9);
        sortedList.add(11);

        // Sorting the list (in case it's not already sorted)
        Collections.sort(sortedList);

        int target = 7;
        int targetIndex = BinarySearch.findTargetIndex(sortedList, target);
        if (targetIndex != -1) {
            System.out.println("The index of target " + target + " is: " + targetIndex);
        } else {
            System.out.println("Target " + target + " not found.");
        }

        // Example 3: Target number not found in the list
        int targetNotFound = 6;
        int targetNotFoundIndex = BinarySearch.findTargetIndex(sortedList, targetNotFound);
        if (targetNotFoundIndex != -1) {
            System.out.println("The index of target " + targetNotFound + " is: " + targetNotFoundIndex);
        } else {
            System.out.println("Target " + targetNotFound + " not found.");
        }
     }
}
