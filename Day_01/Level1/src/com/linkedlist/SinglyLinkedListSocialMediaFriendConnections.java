/*7. Singly Linked List: Social Media Friend Connections
Problem Statement: Create a system to manage social media friend connections using a singly linked list. Each node represents a user with User ID, Name, Age, and List of Friend IDs. Implement the following operations:
Add a friend connection between two users.
Remove a friend connection.
Find mutual friends between two users.
Display all friends of a specific user.
Search for a user by Name or User ID.
Count the number of friends for each user.
Hint:
Use a singly linked list where each node contains a list of friends (which can be another linked list or array of Friend IDs).
For mutual friends, traverse both lists and compare the Friend IDs.
The List of Friend IDs for each user can be implemented as a nested linked list or array.
*/
package com.linkedlist;

import java.util.ArrayList;
import java.util.List;

class UserNode {
    int userId;
    String name;
    int age;
    List<Integer> friendIds; // List to store friend IDs
    UserNode next;

    // Constructor
    public UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }
}

public class SinglyLinkedListSocialMediaFriendConnections {
    private UserNode head;

    // Add a new user to the list
    public void addUser(int userId, String name, int age) {
        UserNode newNode = new UserNode(userId, name, age);
        if (head == null) {
            head = newNode;
        } else {
            UserNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("User " + name + " added.");
    }

    // Search for a user by User ID
    private UserNode findUserById(int userId) {
        UserNode current = head;
        while (current != null) {
            if (current.userId == userId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Add a friend connection between two users
    public void addFriendConnection(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }
        if (!user1.friendIds.contains(userId2)) {
            user1.friendIds.add(userId2);
        }
        if (!user2.friendIds.contains(userId1)) {
            user2.friendIds.add(userId1);
        }
        System.out.println("Friend connection added between " + user1.name + " and " + user2.name + ".");
    }

    // Remove a friend connection
    public void removeFriendConnection(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }
        user1.friendIds.remove((Integer) userId2);
        user2.friendIds.remove((Integer) userId1);
        System.out.println("Friend connection removed between " + user1.name + " and " + user2.name + ".");
    }

    // Find mutual friends between two users
    public void findMutualFriends(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        List<Integer> mutualFriends = new ArrayList<>(user1.friendIds);
        mutualFriends.retainAll(user2.friendIds);

        System.out.println("Mutual friends between " + user1.name + " and " + user2.name + ":");
        for (int friendId : mutualFriends) {
            UserNode friend = findUserById(friendId);
            System.out.println("Friend ID: " + friendId + ", Name: " + (friend != null ? friend.name : "Unknown"));
        }
    }

    // Display all friends of a specific user
    public void displayFriends(int userId) {
        UserNode user = findUserById(userId);

        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("Friends of " + user.name + ":");
        for (int friendId : user.friendIds) {
            UserNode friend = findUserById(friendId);
            System.out.println("Friend ID: " + friendId + ", Name: " + (friend != null ? friend.name : "Unknown"));
        }
    }

    // Count the number of friends for each user
    public void countFriends() {
        UserNode current = head;
        while (current != null) {
            System.out.println(current.name + " has " + current.friendIds.size() + " friends.");
            current = current.next;
        }
    }

    // Search for a user by Name
    public void searchUserByName(String name) {
        UserNode current = head;
        while (current != null) {
            if (current.name.equalsIgnoreCase(name)) {
                System.out.println("User Found: ID: " + current.userId + ", Name: " + current.name + ", Age: " + current.age);
                return;
            }
            current = current.next;
        }
        System.out.println("User with name " + name + " not found.");
    }

    public static void main(String[] args) {
        SinglyLinkedListSocialMediaFriendConnections smfc = new SinglyLinkedListSocialMediaFriendConnections();

        // Adding users
        smfc.addUser(1, "Pratham", 25);
        smfc.addUser(2, "Vivek", 30);
        smfc.addUser(3, "Suraj", 28);

        // Adding friend connections
        smfc.addFriendConnection(1, 2);
        smfc.addFriendConnection(1, 3);

        // Display friends of a user
        smfc.displayFriends(1);

        // Finding mutual friends
        smfc.findMutualFriends(2, 3);

        // Count friends for each user
        smfc.countFriends();

        // Search user by name
        smfc.searchUserByName("Pratham");

        // Removing a friend connection
        smfc.removeFriendConnection(1, 2);

        // Display friends after removal
        smfc.displayFriends(1);
    }
}
