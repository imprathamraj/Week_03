/*1. Problem Statement: Search a Target in a Large Dataset
Objective:
Compare the performance of Linear Search (O(N)) and Binary Search (O(log N)) on different dataset sizes.
Approach:
Linear Search: Scan each element until the target is found.
Binary Search: Sort the data first (O(N log N)), then perform O(log N) search.
Comparative Analysis:
Dataset Size (N)
Linear Search (O(N))
Binary Search (O(log N))
1,000
1ms
0.01ms
10,000
10ms
0.02ms
1,000,000
1s
0.1ms

Expected Result:
Binary Search performs much better for large datasets, provided data is sorted.
*/
package com.algorithmsruntimeanalysisandbigonotation;

import java.util.Arrays;
import java.util.Random;

public class SearchATargetInALargeDataset {
    public void linearSearch(int target, int[] array) {
        //Scanning each element until the target is found
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                System.out.println(target+" found at index " + i);
                return;
            }
        }
    }
    public void binarySearch(int target, int[] array) {
        //Sorting the data first (O(N log N))
        Arrays.sort(array);

        //Performing O(log N) search
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] == target) {
                System.out.println(target+" found at index " + mid);
                return;
            }
            if (array[mid] > target) {
                high = mid - 1;
            }
            else if (array[mid] < target) {
                low = mid + 1;
            }
            else {
                System.out.println(target+" found at index " + mid);
                return;
            }
        }
    }
    public static void main(String[] args) {
        SearchATargetInALargeDataset solution = new SearchATargetInALargeDataset();
        //3 different array with different size
        int[] array = {1000, 10000, 1000000};
        Random randomValue = new Random();
        //Filling data for multiple array;
        for(int i=0; i< array.length; i++){
            System.out.println("__________________________________________________");
            int dataArray[] = new int[array[i]];
            //Filling data
            for(int j=0; j<array[i]; j++){
                dataArray[j] = j;
            }
            //Generating random target
            int target = randomValue.nextInt(array[i]);

            //Output for Liner Search
            long start = System.nanoTime();
            System.out.println("--- Linear Search Algorithm ---");
            solution.linearSearch(target, array);
            long end = System.nanoTime();
            System.out.println("Time: " + (end - start)/1000000 + " ns");

            //Output for Binary Search
            start = System.nanoTime();
            System.out.println("--- Binary Search Algorithm ---");
            solution.binarySearch(target, array);
            end = System.nanoTime();
            System.out.println("Time: " + (end - start)/1000000 + " ns");
        }
    }
}
