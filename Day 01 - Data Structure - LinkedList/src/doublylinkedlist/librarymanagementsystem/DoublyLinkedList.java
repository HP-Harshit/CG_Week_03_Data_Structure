package doublylinkedlist.librarymanagementsystem;

public class DoublyLinkedList {

    // Head of the linked list
    private Node head, tail;

    public DoublyLinkedList() {
        // Initialize the head to null
        this.head = this.tail = null;
    }

    // ===== Insertion =====

    // Adding an element at the end
    public void addAtEnd(String bookTitle, String author, String genre, int id, Boolean availabilityStatus) {
        // Create a new node
        Node newNode = new Node(bookTitle, author, genre, id, availabilityStatus);

        // Check for empty list
        if (head == null) {
            // Make the newNode the head
            head = newNode;
            tail = newNode;
            System.out.println("Record Added");
        } else {
            // Add the newNode at the end
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            System.out.println("Record Added");
        }
    }

    // Adding an element at the Beginning
    public void addAtBeginning(String bookTitle, String author, String genre, int id, Boolean availabilityStatus) {
        // Create a new node
        Node newNode = new Node(bookTitle, author, genre, id, availabilityStatus);
        // Add the newNode to the head
        if (head != null) { // Null check for head
            head.prev = newNode;
        }
        newNode.next = head;
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
        System.out.println("Record Added");
    }

    // Adding an element at a Specific Position
    public void addAtIndex(String bookTitle, String author, String genre, int id, Boolean availabilityStatus, int index) {
        // Create a new node
        Node newNode = new Node(bookTitle, author, genre, id, availabilityStatus);
        // If index is zero
        if (index == 0) {
            // Add the newNode to the head
            addAtBeginning(bookTitle, author, genre, id, availabilityStatus);
            System.out.println("Record Added");
            return;
        }
        int position = 0;
        Node current = head;
        Node previous = null;
        // Traverse to the index
        while (current != null && position < index) {
            previous = current;
            current = current.next;
            position++;
        }
        // If index found, add the node
        if (position == index) {
            previous.next = newNode;
            newNode.next = current;
            current.prev = newNode;
            newNode.prev = previous;
            System.out.println("Record Added");
        } else {
            // If index not found
            System.out.println("Invalid index!");
        }
    }

    // Search by bookTitle
    public void searchByTitle(String bookTitle){
        // Create a reference node
        Node current = head;
        // Traverse the list
        while(current != null){
            // If item found
            if(bookTitle.equalsIgnoreCase(current.bookTitle)){
                System.out.println("Record found");
                System.out.println("Book title: " + current.bookTitle);
                System.out.println("Author: " + current.author);
                System.out.println("Genre: " + current.genre);
                System.out.println("Id: " + current.id);
                System.out.println(current.availabilityStatus?"Available":"Not Available");
                return;
            } else {
                current = current.next;
            }
        }
        // Item not found
        System.out.println("Record not found!");
    }

    // Search by author
    public void searchByAuthor(String author){
        // Create a reference node
        Node current = head;
        // Traverse the list
        while(current != null){
            // If item found
            if(author.equalsIgnoreCase(current.author)){
                System.out.println("Record found");
                System.out.println("Book title: " + current.bookTitle);
                System.out.println("Author: " + current.author);
                System.out.println("Genre: " + current.genre);
                System.out.println("Id: " + current.id);
                System.out.println(current.availabilityStatus?"Available":"Not Available");
                return;
            } else {
                current = current.next;
            }
        }
        // Item not found
        System.out.println("Record not found!");
    }

    // ===== Update =====

    // Update rating by bookTitle
    public void update(boolean availabilityStatus, String bookTitle){
        // Create a reference node
        Node current = head;
        // Traverse the list
        while(current != null){
            // If item found, update the availability status and return
            if(current.bookTitle.equalsIgnoreCase(bookTitle)){
                current.availabilityStatus = availabilityStatus;
                System.out.println("Availability status updated");
                return;
            } else {
                current = current.next;
            }
        }
        // Item not found
        System.out.println("Invalid book title!");
    }

    // ===== Deletion ======

    // Removing element by book Id
    public void delete(int id) {
        // Create references
        Node current = head;

        // Check if head is to be deleted
        if(current != null && current.id == id) {
            head = current.next;
            if(head != null) {
                head.prev = null;
            } else {
                // If the list becomes empty
                tail = null;
            }
            System.out.println("Deleted Record for Book id " + id);
            return;
        }

        // Traverse the list
        while(current != null) {
            // If item found, remove it and update pointers
            if(current.id == id) {
                current.prev.next = current.next;
                if(current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    // Update tail if the last element is deleted
                    tail = current.prev;
                }
                System.out.println("Deleted Record for Book id " + id);
                return;
            }
            current = current.next;
        }

        // If item not found
        System.out.println("Invalid Book Id!");
    }

    // ===== Calculate totalBooks =====
    public void totalBook(){
        Node current = head;
        int totalBooks=0;
        while(current != null){
            totalBooks++;
            current = current.next;
        }
        System.out.println("Total number of books: " + totalBooks);
    }

    // ===== Display =====

    // Display all records in the list Forward
    public void displayListForward(){
        // Create a reference node
        Node current = head;
        Node previous = tail;
        // Traverse the list and print details
        while(current != null) {
            System.out.println("Book Title: " + current.bookTitle + "\tBook Id: " + current.id + "\tAuthor: " + current.author + "\tGenre: " + current.genre + "\tAvailability: " +(current.availabilityStatus ? "Available" : "Not Available"));
            current = current.next;
        }
        totalBook();
    }

    // Display all records in the list Backward
    public void displayListBackward(){
        // Create a reference node
        Node current = tail;
        // Traverse the list in reverse order and print details
        while(current != null) {
            System.out.println("Book Title: " + current.bookTitle + "\tBook Id: " + current.id + "\tAuthor: " + current.author + "\tGenre: " + current.genre + "\tAvailability: " +(current.availabilityStatus ? "Available" : "Not Available"));
            current = current.prev;
        }
        totalBook();
    }
}
