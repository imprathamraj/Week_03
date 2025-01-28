/*4. Singly Linked List: Inventory Management System
Problem Statement: Design an inventory management system using a singly linked list where each node stores information about an item such as Item Name, Item ID, Quantity, and Price. Implement the following functionalities:
Add an item at the beginning, end, or at a specific position.
Remove an item based on Item ID.
Update the quantity of an item by Item ID.
Search for an item based on Item ID or Item Name.
Calculate and display the total value of inventory (Sum of Price * Quantity for each item).
Sort the inventory based on Item Name or Price in ascending or descending order.
Hint:
Use a singly linked list where each node represents an item in the inventory.
Implement sorting using an appropriate algorithm (e.g., merge sort) on the linked list.
For total value calculation, traverse through the list and sum up Quantity * Price for each item.*/

package com.linkedlist;

class InventoryNode {
    String itemName;
    int itemId;
    int itemQuantity;
    int itemPrice;

    InventoryNode next;

    // Constructor
    public InventoryNode(String itemName, int itemId, int itemQuantity, int itemPrice) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.itemQuantity = itemQuantity;
        this.itemPrice = itemPrice;
    }
}

public class SinglyLinkedListInventoryManagementSystem {
    private InventoryNode head;

    // Add a new item at the beginning
    public void addAtBeginning(String itemName, int itemId, int itemQuantity, int itemPrice) {
        InventoryNode newNode = new InventoryNode(itemName, itemId, itemQuantity, itemPrice);
        newNode.next = head;
        head = newNode;
    }

    // Add a new item at the end
    public void addAtEnd(String itemName, int itemId, int itemQuantity, int itemPrice) {
        InventoryNode newNode = new InventoryNode(itemName, itemId, itemQuantity, itemPrice);
        if (head == null) {
            head = newNode;
            return;
        }
        InventoryNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Add a new item at a specific position
    public void addAt(int position, String itemName, int itemId, int itemQuantity, int itemPrice) {
        if (position <= 0) {
            System.out.println("Invalid position.");
            return;
        }
        InventoryNode newNode = new InventoryNode(itemName, itemId, itemQuantity, itemPrice);
        if (position == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }
        InventoryNode current = head;
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

    // Remove an item based on Item ID
    public void removeItem(int itemId) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        if (head.itemId == itemId) {
            System.out.println("Removed " + head.itemName + " from the inventory.\n");
            head = head.next;
            return;
        }
        InventoryNode current = head;
        while (current.next != null && current.next.itemId != itemId) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Item not found.");
            return;
        }
        System.out.println("Removed " + current.next.itemName + " from the inventory.\n");
        current.next = current.next.next;
    }

    // Update the quantity of an item by Item ID
    public void updateQuantity(int itemId, int newQuantity) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        InventoryNode current = head;
        while (current != null) {
            if (current.itemId == itemId) {
                current.itemQuantity = newQuantity;
                System.out.println("Updated quantity for item ID " + itemId + " to " + newQuantity + ".");
                return;
            }
            current = current.next;
        }
        System.out.println("Item not found.");
    }

    // Calculate and display the total value of the inventory
    public int totalInventoryValue() {
        int totalValue = 0;
        InventoryNode current = head;
        while (current != null) {
            totalValue += current.itemQuantity * current.itemPrice;
            current = current.next;
        }
        return totalValue;
    }

    // Display all items in the inventory
    public void displayAll() {
        if (head == null) {
            System.out.println("No items in the inventory.");
            return;
        }
        InventoryNode current = head;
        while (current != null) {
            System.out.println("Item Name : " + current.itemName + "\nItem Id : " + current.itemId +
                    "\nItem Quantity: " + current.itemQuantity + "\nItem Price: " + current.itemPrice + "\n");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedListInventoryManagementSystem ims = new SinglyLinkedListInventoryManagementSystem();

        // Adding items to the inventory
        ims.addAtBeginning("Iphone 16 Pro Max", 10, 2, 120000);
        ims.addAtBeginning("Samsung S25 Ultra", 11, 1, 140000);
        ims.addAtEnd("Motorola Q28", 12, 1, 70000);
        ims.addAt(2, "Samsung Galaxy", 24, 1, 90000);

        // Displaying all records
        System.out.println("------ All Items in Inventory --------");
        ims.displayAll();

        // Removing an item
        ims.removeItem(11);

        // Updating quantity of an item
        ims.updateQuantity(10, 3);

        // Calculating total inventory value
        System.out.println("Total Inventory Value: " + ims.totalInventoryValue());

        // Displaying updated records
        System.out.println("------ Updated Inventory --------");
        ims.displayAll();
    }
}
