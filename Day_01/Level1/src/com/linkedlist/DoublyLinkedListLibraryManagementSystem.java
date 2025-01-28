//5. Doubly Linked List: Library Management System
//Problem Statement: Design a library management system using a doubly linked list. Each node represents a book and contains the following attributes: Book Title, Author, Genre, Book ID, and Availability Status. Implement the following functionalities:
//Add a new book at the beginning, end, or at a specific position.
//Remove a book by Book ID.
//Search for a book by Book Title or Author.
//Update a book’s Availability Status.
//Display all books in forward and reverse order.
//Count the total number of books in the library.
//        Hint:
//Use a doubly linked list with two pointers (next and prev) in each node to facilitate traversal in both directions.
//Ensure that when removing a book, both the next and prev pointers are correctly updated.
//Displaying in reverse order will require traversal from the last node using prev pointers.
package com.linkedlist;
class BookNode {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    BookNode next;
    BookNode prev;

    // Constructor
    public BookNode(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
    }
}
public class DoublyLinkedListLibraryManagementSystem {
    private BookNode head;
    private BookNode tail;
    private int totalBooks = 0;

    // Add a new book at the beginning
    public void addAtBeginning(String title, String author, String genre, int bookId, boolean isAvailable) {
        BookNode newNode = new BookNode(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        totalBooks++;
    }

    // Add a new book at the end
    public void addAtEnd(String title, String author, String genre, int bookId, boolean isAvailable) {
        BookNode newNode = new BookNode(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        totalBooks++;
    }

    // Add a new book at a specific position
    public void addAt(int position, String title, String author, String genre, int bookId, boolean isAvailable) {
        if (position <= 0 || position > totalBooks + 1) {
            System.out.println("Invalid position.");
            return;
        }
        if (position == 1) {
            addAtBeginning(title, author, genre, bookId, isAvailable);
            return;
        }
        if (position == totalBooks + 1) {
            addAtEnd(title, author, genre, bookId, isAvailable);
            return;
        }
        BookNode newNode = new BookNode(title, author, genre, bookId, isAvailable);
        BookNode current = head;
        for (int i = 1; i < position - 1; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        newNode.prev = current;
        current.next.prev = newNode;
        current.next = newNode;
        totalBooks++;
    }

    // Remove a book by Book ID
    public void removeBook(int bookId) {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }
        BookNode current = head;
        while (current != null && current.bookId != bookId) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Book not found.");
            return;
        }
        if (current == head) {
            head = head.next;
            if (head != null) head.prev = null;
        } else if (current == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        System.out.println("Book with ID " + bookId + " removed from the library.");
        totalBooks--;
    }

    // Search for a book by Title or Author
    public void searchBook(String search) {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }
        BookNode current = head;
        boolean found = false;
        while (current != null) {
            if (current.title.equalsIgnoreCase(search) || current.author.equalsIgnoreCase(search)) {
                System.out.println("Book Found: Title: " + current.title + ", Author: " + current.author +
                        ", Genre: " + current.genre + ", ID: " + current.bookId + ", Available: " + current.isAvailable);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No books found matching the search term: " + search);
        }
    }

    // Update a book’s Availability Status
    public void updateAvailability(int bookId, boolean isAvailable) {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }
        BookNode current = head;
        while (current != null && current.bookId != bookId) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Book not found.");
            return;
        }
        current.isAvailable = isAvailable;
        System.out.println("Availability status of book with ID " + bookId + " updated to " + isAvailable + ".");
    }

    // Display all books in forward order
    public void displayForward() {
        if (head == null) {
            System.out.println("No books in the library.");
            return;
        }
        BookNode current = head;
        System.out.println("Books in Forward Order:");
        while (current != null) {
            displayBook(current);
            current = current.next;
        }
    }

    // Display all books in reverse order
    public void displayReverse() {
        if (tail == null) {
            System.out.println("No books in the library.");
            return;
        }
        BookNode current = tail;
        System.out.println("Books in Reverse Order:");
        while (current != null) {
            displayBook(current);
            current = current.prev;
        }
    }

    // Count the total number of books
    public int countBooks() {
        return totalBooks;
    }

    // Helper method to display a single book
    private void displayBook(BookNode book) {
        System.out.println("Title: " + book.title + ", Author: " + book.author + ", Genre: " + book.genre +
                ", ID: " + book.bookId + ", Available: " + book.isAvailable);
    }

    public static void main(String[] args) {
        DoublyLinkedListLibraryManagementSystem library = new DoublyLinkedListLibraryManagementSystem();

        // Adding books
        library.addAtBeginning("Book1", "Pratham", "Genre1", 101, true);
        library.addAtEnd("Book2", "Suraj", "Genre2", 102, true);
        library.addAt(2, "Book3", "Vivek", "Genre3", 103, true);

        // Display all books in forward order
        library.displayForward();

        // Display all books in reverse order
        library.displayReverse();

        // Search for a book
        library.searchBook("1984");

        // Update availability
        library.updateAvailability(102, false);

        // Remove a book
        library.removeBook(101);

        // Display all books after removal
        library.displayForward();

        // Count total books
        System.out.println("Total Books: " + library.countBooks());
    }
}
