/*6. Problem Statement: Comparing Different Data Structures for Searching
Objective:
Compare Array (O(N)), HashSet (O(1)), and TreeSet (O(log N)) for searching elements.
Approach:
Array: Linear search (O(N)).
HashSet: Uses hashing (O(1) on average).
TreeSet: Balanced BST (O(log N)).
Comparative Analysis:
Dataset Size (N)
Array Search (O(N))
HashSet Search (O(1))
TreeSet Search (O(log N))
1,000
1ms
0.01ms
0.1ms
100,000
100ms
0.01ms
10ms
1,000,000
1s
0.01ms
20ms

Expected Result:
HashSet is fastest for lookups but requires extra memory.
TreeSet maintains order but is slightly slower than HashSet.
*/
package com.algorithmsruntimeanalysisandbigonotation;

import java.util.*;

public class ComparingDifferentDataStructuresForSearching {

    // Linear Search (O(N)): Iterates through each element to find the target
    public boolean linearSearch(int[] array, int target) {
        for (int num : array) {
            if (num == target) {
                return true; // Target found
            }
        }
        return false; // Target not found
    }

    // HashSet Search (O(1) on average): Uses hashing for fast lookups
    public boolean hashSetSearch(Set<Integer> hashSet, int target) {
        return hashSet.contains(target); // Direct lookup in HashSet
    }

    // TreeSet Search (O(log N)): Uses a balanced BST for ordered search
    public boolean treeSetSearch(NavigableSet<Integer> treeSet, int target) {
        return treeSet.contains(target); // Lookup in TreeSet
    }

    public static void main(String[] args) {
        ComparingDifferentDataStructuresForSearching solution = new ComparingDifferentDataStructuresForSearching();
        int[] sizes = {1000, 100000, 1000000}; // Different dataset sizes to compare performance
        Random random = new Random();

        for (int size : sizes) {
            System.out.println("__________________________________________________");
            int[] dataArray = new int[size]; // Array for linear search
            Set<Integer> hashSet = new HashSet<>(); // HashSet for O(1) search
            NavigableSet<Integer> treeSet = new TreeSet<>(); // TreeSet for O(log N) search

            // Filling data structures with sequential values
            for (int j = 0; j < size; j++) {
                dataArray[j] = j;
                hashSet.add(j);
                treeSet.add(j);
            }

            int target = random.nextInt(size); // Generating a random target to search

            // Linear Search Timing (O(N))
            long start = System.nanoTime();
            System.out.println("--- Linear Search ---");
            boolean found = solution.linearSearch(dataArray, target);
            long end = System.nanoTime();
            System.out.println("Found: " + found + " | Time: " + (end - start) / 1000000 + " ms");

            // HashSet Search Timing (O(1))
            start = System.nanoTime();
            System.out.println("--- HashSet Search ---");
            found = solution.hashSetSearch(hashSet, target);
            end = System.nanoTime();
            System.out.println("Found: " + found + " | Time: " + (end - start) / 1000000 + " ms");

            // TreeSet Search Timing (O(log N))
            start = System.nanoTime();
            System.out.println("--- TreeSet Search ---");
            found = solution.treeSetSearch(treeSet, target);
            end = System.nanoTime();
            System.out.println("Found: " + found + " | Time: " + (end - start) / 1000000 + " ms");
        }
    }
}

