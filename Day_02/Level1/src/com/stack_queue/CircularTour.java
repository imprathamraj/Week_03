//Circular Tour Problem
//Problem: Given a set of petrol pumps with petrol and distance to the next pump, determine the starting point for completing a
// circular tour.
//Hint: Use a queue to simulate the tour, keeping track of surplus petrol at each pump.
//
package com.stack_queue;
import java.util.LinkedList;
import java.util.Queue;

public class CircularTour {

    // Method to find the starting petrol pump
    public static int canCompleteCircuit(int[] petrol, int[] distance) {
        int totalPetrol = 0;
        int totalCost = 0;
        int start = 0;
        int fuel = 0;
        Queue<Integer> queue = new LinkedList<>();

        // Loop through each petrol pump
        for (int i = 0; i < petrol.length; i++) {
            totalPetrol += petrol[i];
            totalCost += distance[i];
            fuel += petrol[i] - distance[i];
            queue.add(petrol[i] - distance[i]);

            // If fuel goes negative, reset start point
            if (fuel < 0) {
                start = i + 1;
                fuel = 0;
                queue.clear();
            }
        }

        // Check if the circuit is possible
        return (totalPetrol < totalCost) ? -1 : start;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        int result = canCompleteCircuit(petrol, distance);

        // Print the result
        if (result == -1) {
            System.out.println("No solution exists.");
        } else {
            System.out.println("Start from pump: " + result);
        }
    }
}
