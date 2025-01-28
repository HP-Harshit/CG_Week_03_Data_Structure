package singlelinkedlist.socialmediafriendconnections;

public class SocialMediaList {

    private Node head;

    public SocialMediaList() {
        this.head = null;
    }

    // ===== Insertion =====

    // Add a new user
    public void addUser(int userId, String name, int age) {
        Node newUser = new Node(userId, name, age);

        if (head == null) {
            head = newUser;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newUser;
        }
        System.out.println("User Added");
    }

    // Add a friend connection between two users
    public void addFriendConnection(int userId1, int userId2) {
        Node user1 = findUserById(userId1);
        Node user2 = findUserById(userId2);

        if (user1 != null && user2 != null) {
            user1.addFriend(userId2);
            user2.addFriend(userId1);
            System.out.println("Friend Connection Added");
        } else {
            System.out.println("One or both users not found!");
        }
    }

    // Remove a friend connection between two users
    public void removeFriendConnection(int userId1, int userId2) {
        Node user1 = findUserById(userId1);
        Node user2 = findUserById(userId2);

        if (user1 != null && user2 != null) {
            user1.removeFriend(userId2);
            user2.removeFriend(userId1);
            System.out.println("Friend Connection Removed");
        } else {
            System.out.println("One or both users not found!");
        }
    }

    // ===== Search =====

    // Find a user by User ID
    public Node findUserById(int userId) {
        Node current = head;
        while (current != null) {
            if (current.userId == userId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Find mutual friends between two users
    public void findMutualFriends(int userId1, int userId2) {
        Node user1 = findUserById(userId1);
        Node user2 = findUserById(userId2);

        if (user1 != null && user2 != null) {
            System.out.println("Mutual Friends:");
            for (int friendId : user1.friendIds) {
                if (user2.friendIds.contains(friendId)) {
                    System.out.print(friendId + " ");
                }
            }
            System.out.println();
        } else {
            System.out.println("One or both users not found!");
        }
    }

    // Find a user by Name
    public Node findUserByName(String name) {
        Node current = head;
        while (current != null) {
            if (current.name.equalsIgnoreCase(name)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Count the number of friends for each user
    public void countFriends() {
        Node current = head;
        while (current != null) {
            System.out.println("User " + current.name + " has " + current.friendIds.size() + " friends.");
            current = current.next;
        }
    }

    // Display all friends of a specific user
    public void displayFriendsOfUser(int userId) {
        Node user = findUserById(userId);
        if (user != null) {
            user.displayFriends();
        } else {
            System.out.println("User not found!");
        }
    }

    // Display all users in the system
    public void displayAllUsers() {
        Node current = head;
        while (current != null) {
            System.out.println("User ID: " + current.userId + ", Name: " + current.name + ", Age: " + current.age);
            System.out.println("Friends: " + current.friendIds);
            current = current.next;
        }
    }
}
