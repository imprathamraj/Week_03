/*9. Circular Linked List: Online Ticket Reservation System
Problem Statement: Design an online ticket reservation system using a circular linked list, where each node represents a booked ticket. Each node will store the following information: Ticket ID, Customer Name, Movie Name, Seat Number, and Booking Time. Implement the following functionalities:
Add a new ticket reservation at the end of the circular list.
Remove a ticket by Ticket ID.
Display the current tickets in the list.
Search for a ticket by Customer Name or Movie Name.
Calculate the total number of booked tickets.

Hint:
Use a circular linked list to represent the ticket reservations, with the last node’s next pointer pointing to the first node.
When removing a ticket, update the circular pointers accordingly.
For displaying all tickets, traverse the list starting from the first node, looping back after reaching the last node.

*/
package com.linkedlist;

class TicketNode {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    TicketNode next;

    // Constructor
    public TicketNode(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

public class CircularLinkedListOnlineTicketReservationSystem {
    private TicketNode last;

    // Add a new ticket reservation at the end of the circular list
    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        TicketNode newNode = new TicketNode(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (last == null) {
            last = newNode;
            last.next = last; // Circular link
        } else {
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }
        System.out.println("Ticket added: Ticket ID " + ticketId + " for " + customerName);
    }

    // Remove a ticket by Ticket ID
    public void removeTicket(int ticketId) {
        if (last == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        TicketNode current = last.next;
        TicketNode prev = last;

        // Traverse the list to find the ticket
        do {
            if (current.ticketId == ticketId) {
                if (current == last && current.next == last) {
                    // Only one ticket in the list
                    last = null;
                } else {
                    if (current == last) {
                        last = prev;
                    }
                    prev.next = current.next;
                }
                System.out.println("Ticket with ID " + ticketId + " removed.");
                return;
            }
            prev = current;
            current = current.next;
        } while (current != last.next);

        System.out.println("Ticket with ID " + ticketId + " not found.");
    }

    // Display all tickets in the list
    public void displayTickets() {
        if (last == null) {
            System.out.println("No tickets booked.");
            return;
        }

        TicketNode current = last.next;
        System.out.println("Current Tickets:");
        do {
            System.out.println("Ticket ID: " + current.ticketId + ", Customer: " + current.customerName + ", Movie: " + current.movieName +
                    ", Seat: " + current.seatNumber + ", Booking Time: " + current.bookingTime);
            current = current.next;
        } while (current != last.next);
    }

    // Search for a ticket by Customer Name or Movie Name
    public void searchTicket(String searchTerm) {
        if (last == null) {
            System.out.println("No tickets booked.");
            return;
        }

        TicketNode current = last.next;
        boolean found = false;
        do {
            if (current.customerName.equalsIgnoreCase(searchTerm) || current.movieName.equalsIgnoreCase(searchTerm)) {
                System.out.println("Found Ticket: Ticket ID: " + current.ticketId + ", Customer: " + current.customerName +
                        ", Movie: " + current.movieName + ", Seat: " + current.seatNumber + ", Booking Time: " + current.bookingTime);
                found = true;
            }
            current = current.next;
        } while (current != last.next);

        if (!found) {
            System.out.println("No tickets found for the search term: " + searchTerm);
        }
    }

    // Calculate the total number of booked tickets
    public int countTickets() {
        if (last == null) {
            return 0;
        }

        TicketNode current = last.next;
        int count = 0;
        do {
            count++;
            current = current.next;
        } while (current != last.next);

        return count;
    }

    public static void main(String[] args) {
        CircularLinkedListOnlineTicketReservationSystem system = new CircularLinkedListOnlineTicketReservationSystem();

        // Add tickets
        system.addTicket(101, "Pratham", "Inception", "A1", "10:00 AM");
        system.addTicket(102, "Vivek", "Interstellar", "B2", "01:00 PM");
        system.addTicket(103, "Suraj", "Inception", "C3", "04:00 PM");

        // Display tickets
        system.displayTickets();

        // Search for a ticket
        system.searchTicket("Inception");

        // Remove a ticket
        system.removeTicket(102);

        // Display tickets again
        system.displayTickets();

        // Count total tickets
        System.out.println("Total tickets booked: " + system.countTickets());
    }
}
