package com.dsa.searchingalgorithm.binarysearch.searchfortarget;
// Program that performs Binary Search to find a target value in the matrix
public class Matrix {
    // Method for search the target element into the matrix
    public static boolean searchTargetValue(int input[][], int target){
        int rows = input.length;
        int columns = input[0].length;

        // Initialize left as 0 and right as rows * columns - 1
        int left = 0;
        int right = rows * columns -1;
        // Perform binary search
        while(left <= right){
            // Find the middle element index
            int mid = (left + right) / 2;

            // Convert mid index to 2D row and column index
            int midValue = input[mid / columns][mid % columns];

            // Compare the midValue to the target
            if(midValue == target){
                return true;
            }
            // Search the right part
            else if(midValue < target){
                left = mid + 1;
            }
            // Search the left part
            else {
                right = mid - 1;
            }
        }
        return false;
    }
}
