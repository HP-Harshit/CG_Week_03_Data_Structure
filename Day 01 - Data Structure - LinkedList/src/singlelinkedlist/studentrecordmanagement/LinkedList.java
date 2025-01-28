package singlelinkedlist.studentrecordmanagement;

public class LinkedList {

    // Head of the linked list
    private Node head;

    public LinkedList(){
        // Initialize the head to null
        this.head = null;
    }

    // ===== Insertion =====

    // Adding an element at the end
    public void addAtEnd(int rollNumber, String name, int age, String grade){
        // Create a new node
        Node newNode = new Node(rollNumber, name, age, grade);

        // Check for empty list
        if(head == null){
            // Make the newNode the head
            head = newNode;
            System.out.println("Record Added");
        } else {
            // Make a current reference
            Node current = head;
            // Traverse to the end of the list
            while(current.next != null){
                current = current.next;
            }
            // Add the newNode at the end
            current.next = newNode;
            System.out.println("Record Added");
        }
    }

    // Adding an element at the Beginning
    public void addAtBeginning(int rollNumber, String name, int age, String grade){
        // Create a new node
        Node newNode = new Node(rollNumber, name, age, grade);
        // Add the newNode to the head
        newNode.next = head;
        head = newNode;
        System.out.println("Record Added");
    }

    // Adding an element at a Specific Position
    public void addAtIndex(int rollNumber, String name, int age, String grade, int index){
        // Create a new node
        Node newNode = new Node(rollNumber, name, age, grade);
        // If index is zero
        if(index == 0){
            // Add the newNode to the head
            addAtBeginning(rollNumber, name, age, grade);
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
            System.out.println("Record Added");
        } else {
            // If index not found
            System.out.println("Invalid index!");
        }
    }

    // ===== Search =====

    // Search by rollNumber
    public void search(int rollNumber){
        // Create a reference node
        Node current = head;
        // Traverse the list
        while(current != null){
            // If item found
            if(rollNumber == current.rollNumber){
                System.out.println("Record found");
                System.out.println("Rollnumber: " + current.rollNumber);
                System.out.println("Name: " + current.name);
                System.out.println("Age: " + current.age);
                System.out.println("Grade: " + current.grade);
                return;
            } else {
                current = current.next;
            }
        }
        // Item not found
        System.out.println("Record not found!");
    }

    // ===== Update =====

    // Update grade by rollNumber
    public void update(int rollNumber, String grade){
        // Create a reference node
        Node current = head;
        // Traverse the list
        while(current != null){
            // If item found, update the grade and return
            if(current.rollNumber == rollNumber){
                current.grade = grade;
                System.out.println("Grade Updated");
                return;
            } else {
                current = current.next;
            }
        }
        // Item not found
        System.out.println("Invalid rollNumber!");
    }

    // ===== Deletion ======

    // Removing element by Roll Number
    public void delete(int rollNumber){
        // Create references
        Node current = head;
        Node previous = null;
        // Check head
        if(current != null && current.rollNumber == rollNumber){
            head = current.next;
            System.out.println("Deleted Record for rollNumber " + rollNumber);
            return;
        }
        // Traverse the list
        while(current != null){
            // If item found, remove it and return
            if(current.rollNumber == rollNumber){
                previous.next = current.next;
                System.out.println("Deleted Record for rollNumber" + rollNumber);
                return;
            } else {
                previous = current;
                current = current.next;
            }
        }
        // Not found
        System.out.println("Invalid rollNumber!");
    }

    // ===== Display =====

    // Display all records in the list
    public void displayList(){
        // Create a reference node
        Node current = head;
        System.out.println("RollNumber\tName\tAge\tGrade");
        // Traverse the list and print details
        while(current != null) {
            System.out.println("\t" + current.rollNumber + "\t\t" + current.name + "\t" + current.age + "\t" + current.grade);
            current = current.next;
        }
    }
}
