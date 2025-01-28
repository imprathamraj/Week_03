//Circular Linked List: Task Scheduler
//Problem Statement: Create a task scheduler using a circular linked list. Each node in the list represents a task
// with Task ID, Task Name, Priority, and Due Date. Implement the following functionalities:
//Add a task at the beginning, end, or at a specific position in the circular list.
//Remove a task by Task ID.
//View the current task and move to the next task in the circular list.
//Display all tasks in the list starting from the head node.
//        Search for a task by Priority.
//Hint:
//Use a circular linked list where the last node’s next pointer points back to the first node, creating a circular structure.
//Ensure that the list loops when traversed from the head node, so tasks can be revisited in a circular manner.
package com.linkedlist;
class CircularLinkedList {
    static class Node {
        int taskId;
        String taskName;
        int priority;
        String dueDate;
        Node next;

        public Node(int taskId, String taskName, int priority, String dueDate) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.priority = priority;
            this.dueDate = dueDate;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private Node current;

    public CircularLinkedList() {
        head = null;
        tail = null;
        current = null;
    }

    // Add a task at the beginning
    public void addTaskAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Node newNode = new Node(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newNode;
            tail.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            // Update tail's next to new head
            tail.next = head;
        }
        System.out.println("Task added at the beginning: " + taskName);
    }

    // Add a task at the end
    public void addTaskAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Node newNode = new Node(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
        System.out.println("Task added at the end: " + taskName);
    }

    // Add a task at a specific position
    public void addTaskAtPosition(int position, int taskId, String taskName, int priority, String dueDate) {
        if (position < 0) {
            System.out.println("Invalid position!");
            return;
        }

        Node newNode = new Node(taskId, taskName, priority, dueDate);

        if (position == 0) {
            addTaskAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }

        Node temp = head;
        int count = 0;
        while (temp != tail && count < position - 1) {
            temp = temp.next;
            count++;
        }

        if (count != position - 1 && temp != tail) {
            System.out.println("Position out of bounds!");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        if (temp == tail) {
            tail = newNode;
        }

        System.out.println("Task added at position " + position + ": " + taskName);
    }

    // Remove a task by Task ID
    public void removeTaskById(int taskId) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        Node temp = head;
        Node prev = null;

        do {
            if (temp.taskId == taskId) {
                if (temp == head) {
                    head = head.next;
                    tail.next = head;
                } else {
                    prev.next = temp.next;
                }

                if (temp == tail) {
                    tail = prev;
                }

                System.out.println("Task removed: " + temp.taskName);
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Task with ID " + taskId + " not found.");
    }

    // View the current task and move to the next task
    public void viewCurrentTask() {
        if (current == null) {
            current = head;
        }

        if (current != null) {
            System.out.println("Current Task - ID: " + current.taskId + ", Name: " + current.taskName +
                    ", Priority: " + current.priority + ", Due Date: " + current.dueDate);
            current = current.next;
        } else {
            System.out.println("No tasks available.");
        }
    }

    // Display all tasks
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks to display!");
            return;
        }

        System.out.println("All Tasks:");
        Node temp = head;
        do {
            System.out.println("ID: " + temp.taskId + ", Name: " + temp.taskName +
                    ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    // Search for a task by Priority
    public void searchTaskByPriority(int priority) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        boolean found = false;
        Node temp = head;
        do {
            if (temp.priority == priority) {
                System.out.println("Found Task - ID: " + temp.taskId + ", Name: " + temp.taskName +
                        ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tasks found with priority " + priority + ".");
        }
    }
}
public class CircularLinkedListTaskScheduler {
    public static void main(String[] args) {
        CircularLinkedList taskScheduler = new CircularLinkedList();

        // Adding tasks at the beginning
        taskScheduler.addTaskAtBeginning(101, "Task 1", 1, "2025-02-01");
        taskScheduler.addTaskAtBeginning(102, "Task 2", 3, "2025-02-02");

        // Adding tasks at the end
        taskScheduler.addTaskAtEnd(103, "Task 3", 2, "2025-02-03");
        taskScheduler.addTaskAtEnd(104, "Task 4", 1, "2025-02-04");

        // Adding tasks at specific position
        taskScheduler.addTaskAtPosition(2, 105, "Task 5", 2, "2025-02-05");
        taskScheduler.addTaskAtPosition(0, 106, "Task 6", 1, "2025-02-06");

        // Display all tasks
        System.out.println("------ Displaying All Tasks ------");
        taskScheduler.displayAllTasks();

        // Remove task by ID
        taskScheduler.removeTaskById(103);
        System.out.println("***********************************************************");
        // Display tasks after removal
        System.out.println("------ Displaying All Tasks After Removal ------");
        taskScheduler.displayAllTasks();
        System.out.println("***********************************************************");
        // View current task and move to next task
        System.out.println("------ Viewing Current Task ------");
        taskScheduler.viewCurrentTask(); // First task
        taskScheduler.viewCurrentTask(); // Second task
        System.out.println("***********************************************************");
        // Search tasks by priority
        System.out.println("------ Searching Tasks by Priority (1) ------");
        taskScheduler.searchTaskByPriority(1);
        System.out.println("***********************************************************");
        // Search tasks by priority
        System.out.println("------ Searching Tasks by Priority (2) ------");
        taskScheduler.searchTaskByPriority(2);
    }
}
