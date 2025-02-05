//Find the Peak Element in an Array
//Problem:
//A peak element is an element that is greater than its neighbors. Write a program that performs Binary
// Search to find a peak element in an array. If there are multiple peak elements, return any one of them.
//Approach:
//Initialize left as 0 and right as n - 1.
//Perform a binary search:
//Find the middle element mid = (left + right) / 2.
//If arr[mid] > arr[mid - 1] and arr[mid] > arr[mid + 1], arr[mid] is a peak element.
//If arr[mid] < arr[mid - 1], then search the left half, updating right = mid - 1.
//If arr[mid] < arr[mid + 1], then search the right half, updating left = mid + 1.
//Continue until a peak element is found.

package com.dsa.searchingalgorithm.binarysearch.peakelementinarray;

public class PeakElementInAnArray {

    // Finds the peak element in the array using binary search
    public static int peakElementInAnArray(int arr[]) {
        int length = arr.length;
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Check if mid is a peak element
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return arr[mid];
            }

            // If left neighbor is greater, search in the left half
            if (arr[mid] < arr[mid - 1]) {
                right = mid - 1;
            } else {
                // Otherwise, search in the right half
                left = mid + 1;
            }
        }
        return -1; // Return -1 if no peak element found
    }
}
