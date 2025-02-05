//Find the First and Last Occurrence of an Element in a Sorted Array
//Problem:
//Given a sorted array and a target element, write a program that uses Binary Search to find
// the first and last occurrence of the target element in the array. If the element is not found,
// return -1.
//Approach:
//Use binary search to find the first occurrence:
//Perform a regular binary search, but if the target is found, continue searching on the left side
// (right = mid - 1) to find the first occurrence.
//Use binary search to find the last occurrence:
//Similar to finding the first occurrence, but once the target is found, continue searching on the right
// side (left = mid + 1) to find the last occurrence.
//Return the indices of the first and last occurrence. If not found, return -1.

package com.dsa.searchingalgorithm.binarysearch.firstandlastoccurrenceofelement;

public class FirstAndLastOccurrenceOfElementInSortedArray {

    // Finds the first occurrence of target
    public static int firstOccurrenceOfElement(int arr[], int target) {
        int left = 0, right = arr.length - 1, firstOccurrenceElement = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                firstOccurrenceElement = mid;
                right = mid - 1;
            } else if (arr[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return firstOccurrenceElement; // Return index or -1 if not found
    }

    // Finds the last occurrence of target
    public static int lastOccurrenceElement(int arr[], int target) {
        int left = 0, right = arr.length - 1, lastOccurrenceElement = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                lastOccurrenceElement = mid;
                left = mid + 1;
            } else if (arr[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return lastOccurrenceElement; // Return index or -1 if not found
    }

    // Finds both the first and last occurrences of target
    public static int[] firstAndLastOccurrenceOfElement(int arr[], int target) {
        int firstIdx = firstOccurrenceOfElement(arr, target);
        int lastIdx = lastOccurrenceElement(arr, target);
        return new int[]{firstIdx, lastIdx}; // Return both indices
    }
}
