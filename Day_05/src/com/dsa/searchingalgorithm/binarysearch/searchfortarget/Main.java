package com.dsa.searchingalgorithm.binarysearch.searchfortarget;
// Main class for Matrix
public class Main {
    public static void main(String[] args) {
        // Input
        int [][] input = { {1, 4, 7, 11},
                {2, 5, 8, 12},
                {3, 6, 9, 16},
                {10, 13, 14, 17}};

        // Target
        int target = 16;

        // Call searchTargetValue() from Matrix
        boolean result = Matrix.searchTargetValue(input,target);

        // Print the result
        System.out.println("Target " + target + " found : "+ result );
    }
}
