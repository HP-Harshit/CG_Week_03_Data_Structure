package doublylinkedlist.librarymanagementsystem;

public class Main {

    public static void main(String[] args) {
        // Create a new doubly linked list
        DoublyLinkedList libraryList = new DoublyLinkedList();

        // Add DSA books to the list
        libraryList.addAtEnd("Introduction to Algorithms", "Thomas H. Cormen", "DSA", 1, true);
        libraryList.addAtBeginning("Data Structures and Algorithm Analysis in C++", "Mark Allen Weiss", "DSA", 2, true);
        libraryList.addAtEnd("Effective Java", "Joshua Bloch", "Java", 3, true);
        libraryList.addAtIndex("The C++ Programming Language", "Bjarne Stroustrup", "C++", 4, true, 2);
        libraryList.addAtEnd("Clean Code: A Handbook of Agile Software Craftsmanship", "Robert C. Martin", "Software Development", 5, true);
        libraryList.addAtEnd("Java: The Complete Reference", "Herbert Schildt", "Java", 6, true);
        libraryList.addAtBeginning("Algorithms Unlocked", "Thomas H. Cormen", "DSA", 7, true);

        // Display list in forward order
        System.out.println("Books in forward order:");
        libraryList.displayListForward();

        // Display list in backward order
        System.out.println("\nBooks in backward order:");
        libraryList.displayListBackward();

        // Search for books
        System.out.println("\nSearching for books with title 'Introduction to Algorithms':");
        libraryList.searchByTitle("Introduction to Algorithms");
        System.out.println("\nSearching for books by Robert C. Martin:");
        libraryList.searchByAuthor("Robert C. Martin");

        // Update book availability status
        System.out.println("\nUpdating availability status of 'The C++ Programming Language' to Unavailable");
        libraryList.update(false, "The C++ Programming Language");

        // Display list after update
        System.out.println("\nBooks after availability update:");
        libraryList.displayListForward();

        // Delete a book
        System.out.println("\nDeleting book with ID: 4");
        libraryList.delete(4);

        // Display list after deletion
        System.out.println("\nBooks after deletion:");
        libraryList.displayListForward();
    }
}
