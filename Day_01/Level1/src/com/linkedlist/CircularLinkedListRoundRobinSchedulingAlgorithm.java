/*6. Circular Linked List: Round Robin Scheduling Algorithm
Problem Statement: Implement a round-robin CPU scheduling algorithm using a circular linked list. Each node will represent a process and contain Process ID, Burst Time, and Priority. Implement the following functionalities:
Add a new process at the end of the circular list.
Remove a process by Process ID after its execution.
Simulate the scheduling of processes in a round-robin manner with a fixed time quantum.
Display the list of processes in the circular queue after each round.
Calculate and display the average waiting time and turn-around time for all processes.
Hint:
Use a circular linked list to represent a queue of processes.
Each process executes for a fixed time quantum, and then control moves to the next process in the circular list.
Maintain the current node as the process being executed, and after each round, update the list to simulate execution.
*/
package com.linkedlist;

class ProcessNode {
    int processId;
    int burstTime;
    int priority;
    ProcessNode next;

    // Constructor
    public ProcessNode(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
    }
}

public class CircularLinkedListRoundRobinSchedulingAlgorithm {
    private ProcessNode tail;

    // Add a new process at the end of the circular list
    public void addProcess(int processId, int burstTime, int priority) {
        ProcessNode newNode = new ProcessNode(processId, burstTime, priority);
        if (tail == null) {
            tail = newNode;
            tail.next = tail; // Circular linking
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Remove a process by Process ID
    public void removeProcess(int processId) {
        if (tail == null) {
            System.out.println("No processes in the queue.");
            return;
        }
        ProcessNode current = tail.next;
        ProcessNode prev = tail;
        do {
            if (current.processId == processId) {
                if (current == tail && current.next == tail) {
                    tail = null; // Single node case
                } else {
                    prev.next = current.next;
                    if (current == tail) {
                        tail = prev; // Update tail if the removed node is the tail
                    }
                }
                System.out.println("Process " + processId + " removed.");
                return;
            }
            prev = current;
            current = current.next;
        } while (current != tail.next);
        System.out.println("Process ID " + processId + " not found.");
    }

    // Simulate the scheduling of processes in a round-robin manner
    public void simulateRoundRobin(int timeQuantum) {
        if (tail == null) {
            System.out.println("No processes in the queue.");
            return;
        }
        ProcessNode current = tail.next;
        int totalProcesses = countProcesses();
        int totalWaitingTime = 0, totalTurnAroundTime = 0;

        while (totalProcesses > 0) {
            if (current.burstTime > 0) {
                int executionTime = Math.min(current.burstTime, timeQuantum);
                System.out.println("Executing Process " + current.processId + " for " + executionTime + " units.");
                current.burstTime -= executionTime;

                if (current.burstTime == 0) {
                    System.out.println("Process " + current.processId + " completed.");
                    totalTurnAroundTime += totalWaitingTime + executionTime;
                    removeProcess(current.processId);
                    totalProcesses--;
                } else {
                    totalWaitingTime += executionTime;
                }
            }
            current = current.next;
        }

        System.out.println("Average Waiting Time: " + (totalWaitingTime / (double) countProcesses()));
        System.out.println("Average Turnaround Time: " + (totalTurnAroundTime / (double) countProcesses()));
    }

    // Display the list of processes in the circular queue
    public void displayProcesses() {
        if (tail == null) {
            System.out.println("No processes in the queue.");
            return;
        }
        ProcessNode current = tail.next;
        System.out.println("Processes in the queue:");
        do {
            System.out.println("Process ID: " + current.processId + ", Burst Time: " + current.burstTime + ", Priority: " + current.priority);
            current = current.next;
        } while (current != tail.next);
    }

    // Count the total number of processes
    public int countProcesses() {
        if (tail == null) {
            return 0;
        }
        ProcessNode current = tail.next;
        int count = 0;
        do {
            count++;
            current = current.next;
        } while (current != tail.next);
        return count;
    }

    public static void main(String[] args) {
        CircularLinkedListRoundRobinSchedulingAlgorithm scheduler = new CircularLinkedListRoundRobinSchedulingAlgorithm();

        // Adding processes to the queue
        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 5, 2);
        scheduler.addProcess(3, 8, 1);

        // Display processes
        scheduler.displayProcesses();

        // Simulate round-robin scheduling with time quantum of 4
        System.out.println("\nSimulating Round Robin Scheduling:");
        scheduler.simulateRoundRobin(4);

        // Display remaining processes (if any)
        System.out.println("\nRemaining Processes in the Queue:");
        scheduler.displayProcesses();
    }
}
