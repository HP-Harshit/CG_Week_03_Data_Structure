package doublylinkedlist.moviemanagementsystem;

public class DoublyLinkedList {

    // Head of the linked list
    private Node head, tail;

    public DoublyLinkedList(){
        // Initialize the head to null
        this.head = this.tail = null;
    }

    // ===== Insertion =====

    // Adding an element at the end
    public void addAtEnd(String movieTitle, String director, int yearOfRelease, double rating){
        // Create a new node
        Node newNode = new Node(movieTitle, director, yearOfRelease, rating);

        // Check for empty list
        if(head == null){
            // Make the newNode the head
            head = newNode;
            tail = newNode;
            System.out.println("Record Added");
        } else {
            // Add the newNode at the end
            Node current = tail;
            current.next = newNode;
            newNode.prev = current;
            tail = newNode;
            System.out.println("Record Added");
        }
    }

    // Adding an element at the Beginning
    public void addAtBeginning(String movieTitle, String director, int yearOfRelease, double rating){
        // Create a new node
        Node newNode = new Node(movieTitle, director, yearOfRelease, rating);
        // Add the newNode to the head
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        System.out.println("Record Added");
    }

    // Adding an element at a Specific Position
    public void addAtIndex(String movieTitle, String director, int yearOfRelease, double rating, int index){
        // Create a new node
        Node newNode = new Node(movieTitle, director, yearOfRelease, rating);
        // If index is zero
        if(index == 0){
            // Add the newNode to the head
            addAtBeginning(movieTitle, director, yearOfRelease, rating);
            System.out.println("Record Added");
            return;
        }
        int position = 0;
        Node current = head;
        Node previous = null;
        // Traverse to the index
        while(current.next != null && position < index){
            previous = current;
            current = current.next;
            position++;
        }
        // If index found, add the node
        if(position == index){
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

    // ===== Search =====

    // Search by director
    public void searchByDirector(String director){
        // Create a reference node
        Node current = head;
        // Traverse the list
        while(current != null){
            // If item found
            if(director.equalsIgnoreCase(current.director)){
                System.out.println("Record found");
                System.out.println("Movie title: " + current.movieTitle);
                System.out.println("Director: " + current.director);
                System.out.println("Year of release: " + current.yearOfRelease);
                System.out.println("rating: " + current.rating);
                return;
            } else {
                current = current.next;
            }
        }
        // Item not found
        System.out.println("Record not found!");
    }

    // Search by rating
    public void searchByRating(double rating){
        // Create a reference node
        Node current = head;
        // Traverse the list
        while(current != null){
            // If item found
            if(rating == current.rating){
                System.out.println("Record found");
                System.out.println("Movie title: " + current.movieTitle);
                System.out.println("Director: " + current.director);
                System.out.println("Year of release: " + current.yearOfRelease);
                System.out.println("rating: " + current.rating);
                return;
            } else {
                current = current.next;
            }
        }
        // Item not found
        System.out.println("Record not found!");
    }

    // ===== Update =====

    // Update rating by movieTitle
    public void update(double rating, String movieTitle){
        // Create a reference node
        Node current = head;
        // Traverse the list
        while(current != null){
            // If item found, update the grade and return
            if(current.movieTitle.equalsIgnoreCase(movieTitle)){
                current.rating = rating;
                System.out.println("Grade Updated");
                return;
            } else {
                current = current.next;
            }
        }
        // Item not found
        System.out.println("Invalid movieTitle!");
    }

    // ===== Deletion ======

    // Removing element by movieTitle
    public void delete(String movieTitle){
        // Create references
        Node current = head;
        Node previous = null;
        // Check head
        if(current != null && current.movieTitle.equalsIgnoreCase(movieTitle)){
            head = current.next;
            head.prev = null;
            System.out.println("Deleted Record for movie title " + movieTitle);
            return;
        }
        // Traverse the list
        while(current != null){
            // If item found, remove it and return
            if(current.movieTitle.equalsIgnoreCase(movieTitle) && current.next != null){
                previous.next = current.next;
                current.next.prev = previous;
                System.out.println("Deleted Record for movie title" + movieTitle);
                return;
            } else if(current.movieTitle.equalsIgnoreCase(movieTitle) && current.next == null){
                previous.next = null;
                tail = previous;
                System.out.println("Deleted Record for movie title" + movieTitle);
                return;
            } else {
                previous = current;
                current = current.next;
            }
        }
        // Not found
        System.out.println("Invalid Movie title!");
    }

    // ===== Display =====

    // Display all records in the list Forward
    public void displayListForward(){
        // Create a reference node
        Node current = head;
        Node previous = tail;
        // Traverse the list and print details
        while(current != null) {
            System.out.println("Movie Title: " + previous.movieTitle + ", Director: " + previous.director + ", Year of Release: " + previous.yearOfRelease + ", Rating: " + previous.rating);
            current = current.next;
        }
    }

    // Display all records in the list Forward
    public void displayListBackward(){
        // Create a reference node
        Node current = head;
        Node previous = tail;

        // Traverse the list and print details
        while(previous!=null){
            System.out.println("Movie Title: " + previous.movieTitle + ", Director: " + previous.director + ", Year of Release: " + previous.yearOfRelease + ", Rating: " + previous.rating);
            previous = previous.prev;
        }
    }
}
