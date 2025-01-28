package singlelinkedlist.socialmediafriendconnections;

public class Main {

    public static void main(String[] args) {
        // Create a new social media network
        SocialMediaList network = new SocialMediaList();

        // Add users to the network
        network.addUser(1, "Bob", 25);
        network.addUser(2, "Charlie", 28);
        network.addUser(3, "Jack", 30);
        network.addUser(4, "John", 22);
        network.addUser(5, "Chef", 26);
        network.addUser(6, "Alice", 24);
        System.out.println();

        // Add friend connections
        network.addFriendConnection(1, 2); // Bob and Charlie
        network.addFriendConnection(1, 3); // Bob and Jack
        network.addFriendConnection(2, 4); // Charlie and John
        network.addFriendConnection(5, 3); // Chef and Jack
        network.addFriendConnection(6, 1); // Alice and Bob
        network.addFriendConnection(6, 5); // Alice and Chef
        System.out.println();

        // Display all users
        System.out.println("All users in the Social Media network:");
        network.displayAllUsers();
        System.out.println();

        // Display friends of a specific user
        System.out.println("\nFriends of Bob:");
        network.displayFriendsOfUser(1); // Display Bob's friends
        System.out.println();

        // Display friends of another specific user
        System.out.println("\nFriends of Charlie:");
        network.displayFriendsOfUser(2); // Display Charlie's friends
        System.out.println();

        // Find mutual friends between two users
        System.out.println("\nMutual friends between Bob and Alice:");
        network.findMutualFriends(1, 6); // Find mutual friends between Bob and Alice
        System.out.println();

        // Count the number of friends for each user
        System.out.println("\nCounting friends for each user:");
        network.countFriends();
        System.out.println();

        // Search for a user by Name
        System.out.println("\nSearching for user 'Alice':");
        Node user = network.findUserByName("Alice");
        if (user != null) {
            System.out.println("User found: ID = " + user.userId + ", Name = " + user.name + ", Age = " + user.age);
        } else {
            System.out.println("User not found!");
        }

        // Remove a friend connection
        System.out.println("\nRemoving friend connection between Bob and Alice");
        network.removeFriendConnection(1, 6);
        System.out.println();

        // Display Bob's friends after removal
        System.out.println("\nFriends of Bob after removing connection with Alice:");
        network.displayFriendsOfUser(1);
        System.out.println();

        // Display all users after removing a friend connection
        System.out.println("\nAll users in the Social Media network after removing friend connection:");
        network.displayAllUsers();
    }
}
