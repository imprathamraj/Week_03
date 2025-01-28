//Movie Management System
//Problem Statement: Implement a movie management system using a doubly linked list. Each node will represent a
// movie and contain Movie Title, Director, Year of Release, and Rating. Implement the following functionalities:
//Add a movie record at the beginning, end, or at a specific position.
//Remove a movie record by Movie Title.
//        Search for a movie record by Director or Rating.
//Display all movie records in both forward and reverse order.
//Update a movie's Rating based on the Movie Title.
//Hint:
//Use a doubly linked list where each node has two pointers: one pointing to the next node and the other to the previous node.
//Maintain pointers to both the head and tail for easier insertion and deletion at both ends.
//For reverse display, start from the tail and traverse backward using the prev pointers.

package com.linkedlist;

class DoublyLinkedList {

    static class Node {
        String title;
        String directorName;
        String yearOfRelease;

        int rating;
        Node prev;
        Node next;

        public Node(String title, String directorName, String yearOfRelease, int rating) {
            this.title = title;
            this.directorName = directorName;
            this.yearOfRelease = yearOfRelease;
            this.rating = rating;
            prev = null;
            next = null;
        }
    }

    public static Node head;
    public static Node tail;

    public static int size;

    DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }


    //Adding movie to the first
    public void addMovieAtFirst(String title, String directorName, String yearOfRelease, int rating) {
        Node newNode = new Node(title, directorName, yearOfRelease, rating);

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addMovieAtEnd(String title, String directorName, String yearOfRelease, int rating) {
        Node newNode = new Node(title, directorName, yearOfRelease, rating);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void addMovieSpecificPosition(int index, String title, String directorName, String yearOfRelease, int rating) {

        if (index < 0 || index > size) {
            System.out.println("Index is not available");
            return;
        }

        // Handle the case for an empty list
        if (head == null && index == 0) {
            // If the list is empty, add at the first position
            addMovieAtFirst(title, directorName, yearOfRelease, rating);
            return;
        }

        Node newNode = new Node(title, directorName, yearOfRelease, rating);


        if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else {
            // Traverse to the node just before the position where we want to insert
            Node temp = head;
            int idx = 0;
            while (temp != null && idx < index - 1) {
                temp = temp.next;
                idx++;
            }

            // Insert the new node in the correct position
            newNode.next = temp.next;
            if (temp.next != null) {
                temp.next.prev = newNode;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }


        if (newNode.next == null) {
            tail = newNode;
        }

        size++;
    }

    public void removeMovieByTitle(String title) {
        if (head == null) {
            System.out.println("Empty List");
            return;
        }

        Node temp = head;

        // Traverse the
        while (temp != null) {
            if (temp.title.equals(title)) {
                // Node is found, remove it
                if (temp == head) {

                    head = head.next;
                    if (head != null) {
                        head.prev = null;
                    }
                } else if (temp == tail) {
                    // If the node is the tail
                    tail = tail.prev;
                    tail.next = null; // Ensure the new tail has no next pointer
                } else {
                    // If the node is in the middle
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }

                size--;
                System.out.println("Movie deleted: " + title);
                return;
            }
            temp = temp.next; // Move to next node
        }

        // If the movie wasn't found in the list
        System.out.println("Movie with title '" + title + "' not found.");
    }
    // Search for a movie by director or rating
    public void searchMovie(String directorName, int rating) {
        if (head == null) {
            System.out.println("Empty List");
            return;
        }

        Node temp = head;
        boolean found = false;

        System.out.println("Searching for movies by Director: '" + directorName + "' or Rating: '" + rating + "'...");
        while (temp != null) {
            if (temp.directorName.equals(directorName) || temp.rating == rating) {
                System.out.println("Found Movie - Title: " + temp.title +
                        ", Director: " + temp.directorName +
                        ", Year: " + temp.yearOfRelease +
                        ", Rating: " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("No movies found for Director: '" + directorName + "' or Rating: '" + rating + "'.");
        }
    }

    // Display all movie records in forward order
    public void displayForward() {
        if (head == null) {
            System.out.println("Empty List");
            return;
        }

        System.out.println("Displaying movies in forward order:");
        Node temp = head;
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Director: " + temp.directorName +
                    ", Year: " + temp.yearOfRelease + ", Rating: " + temp.rating);
            temp = temp.next;
        }
    }

    // Display all movie records in reverse order
    public void displayReverse() {
        if (tail == null) {
            System.out.println("Empty List");
            return;
        }

        System.out.println("Displaying movies in reverse order:");
        Node temp = tail;
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Director: " + temp.directorName +
                    ", Year: " + temp.yearOfRelease + ", Rating: " + temp.rating);
            temp = temp.prev;
        }
    }

    // Update movie rating by title
    public void updateRatingByTitle(String title, int newRating) {
        if (head == null) {
            System.out.println("Empty List");
            return;
        }

        Node temp = head;
        boolean updated = false;

        while (temp != null) {
            if (temp.title.equals(title)) {
                System.out.println("Updating rating for movie '" + title + "' from " + temp.rating + " to " + newRating);
                temp.rating = newRating;
                updated = true;
                break;
            }
            temp = temp.next;
        }

        if (!updated) {
            System.out.println("Movie with title '" + title + "' not found.");
        }
    }
}

public class DoublyLinkedListMovieManagementSystem {
    public static void main(String[] args) {
        DoublyLinkedList ll =new DoublyLinkedList();
        ll.addMovieAtFirst("Laadla", "Raj Kanwar", "1994", 8);
        ll.addMovieAtFirst("Pariwaar", "Rajesh Sharma", "2001", 7);

        // Add movies at the end
        ll.addMovieAtEnd("Saaho", "Sujeeth", "2019", 6);
        ll.addMovieAtEnd("Kalki", "Prasanth Varma", "2022", 8);

        // Add a movie at a specific position
        ll.addMovieSpecificPosition(2, "Kalki 2", "Prasanth Varma", "2024", 9);

        // Display movies in forward order
        System.out.println("\nMovies in forward order:");
        ll.displayForward();

        // Display movies in reverse order
        System.out.println("\nMovies in reverse order:");
        ll.displayReverse();

        // Search for a movie by director or rating
        System.out.println("\nSearching for movies by Director: 'Prasanth Varma' or Rating: 8");
        ll.searchMovie("Prasanth Varma", 8);

        // Update a movie's rating by title
        System.out.println("\nUpdating rating of 'Saaho' to 7.");
        ll.updateRatingByTitle("Saaho", 7);

        // Display movies again after update
        System.out.println("\nMovies after updating rating:");
        ll.displayForward();

        // Remove a movie by title
        System.out.println("\nRemoving movie: 'Pariwaar'.");
        ll.removeMovieByTitle("Pariwaar");

        // Display movies after removal
        System.out.println("\nMovies after removal:");
        ll.displayForward();

    }
}
