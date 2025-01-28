/*1. Singly Linked List: Student Record Management
Problem Statement: Create a program to manage student records using a singly linked list. Each node will store information about a student, including their Roll Number, Name, Age, and Grade. Implement the following operations:
Add a new student record at the beginning, end, or at a specific position.
Delete a student record by Roll Number.
Search for a student record by Roll Number.
Display all student records.
Update a student's grade based on their Roll Number.
Hint:
Use a singly linked list where each node contains student information and a pointer to the next node.
The head of the list will represent the first student, and the last node’s next pointer will be null.
Update the next pointers when inserting or deleting nodes.
*/
package com.linkedlist;

// Define a class to represent a node in the singly linked list
class StudentNode {
    int rollNumber; // Roll number of the student
    String name; // Name of the student
    int age; // Age of the student
    String grade; // Grade of the student
    StudentNode next; // Pointer to the next node in the list

    // Constructor to initialize a student record
    public StudentNode(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

public class SinglyLinkedListStudentRecordManagement {
    private StudentNode head; // Head of the linked list

    // Adding a new student record at the beginning
    public void addAtBeginning(int rollNumber, String name, int age, String grade) {
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
        newNode.next = head;
        head = newNode;
    }

    // Add a new student record at the end
    public void addAtEnd(int rollNumber, String name, int age, String grade) {
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
        if (head == null) {
            head = newNode;
            return;
        }
        StudentNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Add a new student record at a specific position (1-based index)
    public void addAtPosition(int position, int rollNumber, String name, int age, String grade) {
        if (position <= 0) {
            System.out.println("Invalid position.");
            return;
        }
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
        if (position == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }
        StudentNode current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Position out of bounds.");
            return;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    // Delete a student record by Roll Number
    public void deleteByRollNumber(int rollNumber) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.rollNumber == rollNumber) {
            head = head.next;
            System.out.println("Record deleted successfully.");
            return;
        }
        StudentNode current = head;
        while (current.next != null && current.next.rollNumber != rollNumber) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Record not found.");
            return;
        }
        current.next = current.next.next;
        System.out.println("Record deleted successfully.");
    }

    // Search for a student record by Roll Number
    public void searchByRollNumber(int rollNumber) {
        StudentNode current = head;
        while (current != null) {
            if (current.rollNumber == rollNumber) {
                System.out.println("Record found: Roll Number: " + current.rollNumber + ", Name: " + current.name + ", Age: " + current.age + ", Grade: " + current.grade);
                return;
            }
            current = current.next;
        }
        System.out.println("Record not found.");
    }

    // Display all student records
    public void displayAll() {
        if (head == null) {
            System.out.println("No records to display.");
            return;
        }
        StudentNode current = head;
        while (current != null) {
            System.out.println("Roll Number: " + current.rollNumber + ", Name: " + current.name + ", Age: " + current.age + ", Grade: " + current.grade);
            current = current.next;
        }
    }

    // Update a student's grade by Roll Number
    public void updateGrade(int rollNumber, String newGrade) {
        StudentNode current = head;
        while (current != null) {
            if (current.rollNumber == rollNumber) {
                current.grade = newGrade;
                System.out.println("Grade updated successfully.");
                return;
            }
            current = current.next;
        }
        System.out.println("Record not found.");
    }

    public static void main(String[] args) {
        SinglyLinkedListStudentRecordManagement srm = new SinglyLinkedListStudentRecordManagement();

        // Adding student records
        srm.addAtEnd(1, "Alice", 20, "A");
        srm.addAtEnd(2, "Bob", 21, "B");
        srm.addAtEnd(3, "Charlie", 22, "C");

        // Displaying all records

        System.out.println("All Student Records:");
        srm.displayAll();

        // Adding a record at the beginning
        srm.addAtBeginning(0, "Zara", 19, "A+");

        // Adding a record at position 3
        srm.addAtPosition(3, 4, "Dave", 23, "B+");

        // Displaying all records after additions
        System.out.println("\nAll Student Records After Additions:");
        srm.displayAll();

        // Searching for a record by Roll Number
        System.out.println("\nSearch for Roll Number 2:");
        srm.searchByRollNumber(2);

        // Updating a student's grade
        System.out.println("\nUpdating Grade for Roll Number 3:");
        srm.updateGrade(3, "A");

        // Displaying all records after update
        System.out.println("\nAll Student Records After Update:");
        srm.displayAll();

        // Deleting a record by Roll Number
        System.out.println("\nDeleting Record with Roll Number 1:");
        srm.deleteByRollNumber(1);

        // Displaying all records after deletion
        System.out.println("\nAll Student Records After Deletion:");
        srm.displayAll();
    }
}