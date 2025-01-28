package singlelinkedlist.socialmediafriendconnections;

import java.util.ArrayList; // Import ArrayList for managing friends

public class Node {
    int userId;
    String name;
    int age;
    ArrayList<Integer> friendIds; // List of Friend IDs
    Node next;

    // Constructor to initialize a new node
    public Node(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>(); // Initialize friendIds with an empty list
        this.next = null; // Initialize next as null
    }

    // Method to add a friend connection
    public void addFriend(int friendId) {
        if (!friendIds.contains(friendId)) {
            friendIds.add(friendId);
        }
    }

    // Method to remove a friend connection
    public void removeFriend(int friendId) {
        friendIds.remove((Integer) friendId);
    }

    // Method to display all friends
    public void displayFriends() {
        System.out.println("User ID: " + userId + ", Name: " + name + ", Age: " + age);
        System.out.println("Friends: " + friendIds);
    }
}
