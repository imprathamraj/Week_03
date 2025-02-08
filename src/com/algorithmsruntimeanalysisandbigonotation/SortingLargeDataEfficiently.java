/*2. Problem Statement: Sorting Large Data Efficiently
Objective:
Compare sorting algorithms Bubble Sort (O(N²)), Merge Sort (O(N log N)), and Quick Sort (O(N log N)).
Approach:
Bubble Sort: Repeated swapping (inefficient for large data).
Merge Sort: Divide & Conquer approach (stable).
Quick Sort: Partition-based approach (fast but unstable).



Comparative Analysis:
Dataset Size (N)
Bubble Sort (O(N²))
Merge Sort (O(N log N))
Quick Sort (O(N log N))
1,000
50ms
5ms
3ms
10,000
5s
50ms
30ms
1,000,000
Unfeasible (>1hr)
3s
2s

Expected Result:
Bubble Sort is impractical for large datasets.
Merge Sort & Quick Sort perform well.

3. Problem Statement: String Concatenation Performance
Objective:
Compare the performance of String (O(N²)), StringBuilder (O(N)), and StringBuffer (O(N)) when concatenating a million strings.
Approach:
Using String (Immutable, creates new object each time)
Using StringBuilder (Fast, mutable, thread-unsafe)
Using StringBuffer (Thread-safe, slightly slower than StringBuilder)
Comparative Analysis:
Operations Count (N)
String (O(N²))
StringBuilder (O(N))
StringBuffer (O(N))
1,000
10ms
1ms
2ms
10,000
1s
10ms
12ms
1,000,000
30m (Unusable)
50ms
60ms

Expected Result:
StringBuilder & StringBuffer are much more efficient than String.
Use StringBuilder for single-threaded operations and StringBuffer for multi-threaded.
*/
package com.algorithmsruntimeanalysisandbigonotation;

import java.util.*;

public class SortingLargeDataEfficiently {

    // Implementing Bubble Sort (O(N²))
    public void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Implementing Merge Sort (O(N log N))
    public void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        System.arraycopy(array, left, leftArray, 0, n1);
        System.arraycopy(array, mid + 1, rightArray, 0, n2);
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }
        while (i < n1) {
            array[k++] = leftArray[i++];
        }
        while (j < n2) {
            array[k++] = rightArray[j++];
        }
    }

    // Implementing Quick Sort (O(N log N))
    public void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        SortingLargeDataEfficiently solution = new SortingLargeDataEfficiently();
        int[] sizes = {1000, 10000, 100000};
        Random random = new Random();

        for (int size : sizes) {
            System.out.println("__________________________________________________");
            int[] dataArray = new int[size];
            for (int j = 0; j < size; j++) {
                dataArray[j] = random.nextInt(size);
            }

            // Bubble Sort Timing
            int[] copyArray = dataArray.clone();
            long start = System.nanoTime();
            System.out.println("--- Bubble Sort Algorithm ---");
            solution.bubbleSort(copyArray);
            long end = System.nanoTime();
            System.out.println("Time: " + (end - start) / 1000000 + " ms");

            // Merge Sort Timing
            copyArray = dataArray.clone();
            start = System.nanoTime();
            System.out.println("--- Merge Sort Algorithm ---");
            solution.mergeSort(copyArray, 0, copyArray.length - 1);
            end = System.nanoTime();
            System.out.println("Time: " + (end - start) / 1000000 + " ms");

            // Quick Sort Timing
            copyArray = dataArray.clone();
            start = System.nanoTime();
            System.out.println("--- Quick Sort Algorithm ---");
            solution.quickSort(copyArray, 0, copyArray.length - 1);
            end = System.nanoTime();
            System.out.println("Time: " + (end - start) / 1000000 + " ms");
        }
    }
}