//Implement a Queue Using Stacks
//        Problem: Design a queue using two stacks such that enqueue and dequeue operations are performed efficiently.
//        Hint: Use one stack for enqueue and another stack for dequeue. Transfer elements between stacks as needed.

package com.stack_queue;

import java.util.Stack;

class QueueUsingStacks {
    private Stack<Integer> enStack;
    private Stack<Integer> deStack;

    //Constructor
    public QueueUsingStacks() {
        enStack = new Stack<>();
        deStack = new Stack<>();
    }

    //Method to return queue
    public String toString() {
        Stack<Integer> temp = new Stack<>();
        temp.addAll(deStack); // First add deStack (FIFO order)
        for (int i = enStack.size() - 1; i >= 0; i--) {
            temp.add(enStack.get(i)); // Then add enStack in correct order
        }
        return "Queue: " + temp;
    }

    //Method to add an element
    public void enqueue(int value) {
        enStack.push(value);
        System.out.println("Enqueued: " + value);
    }
    //Method to remove an element
    public int dequeue() {
        if (deStack.isEmpty()) {
            if (enStack.isEmpty()) {
                System.out.println("Queue is empty!");
            }
            while (!enStack.isEmpty()) {
                deStack.push(enStack.pop());
            }
        }
        int removed = deStack.pop();
        System.out.println("Dequeued: " + removed);
        return removed;
    }
}

public class ImplementAQueueUsingStacks {
    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();

        queue.enqueue(1);  // Enqueue 1
        queue.enqueue(2);  // Enqueue 2
        queue.enqueue(3);  // Enqueue 3
        System.out.println(queue);

        queue.dequeue();         // Remove 1
        System.out.println(queue);

        queue.enqueue(4);  // Enqueue 4
        System.out.println(queue);

        queue.dequeue();         // Remove 2
        System.out.println(queue);

    }
}
