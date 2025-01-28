package singlelinkedlist.inventorymanagementsystem;

public class LinkedList {

    // Head of the linkedlist
    private Node head;

    public LinkedList(){
        // Initialize the head to null
        this.head = null;
    }

    // ===== Insertion =====

    // Adding element at the end
    public void addAtEnd(int itemId, String name, double price, int quantity){
        // Create a new node
        Node newNode = new Node(itemId, name, price, quantity);

        // Check for empty list
        if(head == null){
            // Make the newNode the head
            head = newNode;
            System.out.println("Item Added");
        } else {
            // Make a current reference
            Node current = head;
            // Traverse to the end of the list
            while(current.next != null){
                current = current.next;
            }
            // Add the newNode at the end
            current.next = newNode;
            System.out.println("Item Added");
        }
    }

    // Adding element at the Beginning
    public void addAtBeginning(int itemId, String name, double price, int quantity){
        // Create a newNode
        Node newNode = new Node(itemId, name, price, quantity);
        // Add the newNode to the head
        newNode.next = head;
        head = newNode;
        System.out.println("Item Added");
    }

    // Adding element at the Specific Position
    public void addAtIndex(int itemId, String name, double price, int quantity, int index){
        // Create a new node
        Node newNode = new Node(itemId, name, price, quantity);
        // If index is zero
        if(index == 0){
            // Add the newNode to the head
            addAtBeginning(itemId, name, price, quantity);
            System.out.println("Item Added");
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
            System.out.println("Item Added");
        } else {
            // If index not found
            System.out.println("Invalid index!");
        }
    }

    // ===== Search =====

    // Search by ItemId
    public void searchByItemId(int itemId){
        // Create a reference node
        Node current = head;
        // traverse the list
        while(current != null){
            // If item found
            if(itemId == current.itemId){
                System.out.println("Record found");
                System.out.println("Item Id: " + current.itemId);
                System.out.println("Name: " + current.itemName);
                System.out.println("Price: " + current.price);
                System.out.println("Quantity: " + current.quantity);
                return;
            } else {
                current = current.next;
            }
        }
        // Item not found
        System.out.println("Record not found!");
    }
    // Search by ItemName
    public void searchByItemName(String itemName){
        // Create a reference node
        Node current = head;
        // Traverse the list
        while(current != null){
            if(itemName.equalsIgnoreCase(current.itemName)){
                System.out.println("Record found");
                System.out.println("Item Id: " + current.itemId);
                System.out.println("Name: " + current.itemName);
                System.out.println("Price: " + current.price);
                System.out.println("Quantity: " + current.quantity);
                return;
            } else {
                current = current.next;
            }
        }
        // Not found
        System.out.println("Record not found!");
    }

    // ===== Update =====

    public void update(int itemId, int quantity){
        // Create a reference node
        Node current = head;
        // Traverse the list
        while(current != null){
            // If item found, update the quantity and return
            if(current.itemId == itemId){
                current.quantity = quantity;
                System.out.println("Quantity Updated");
                return;
            } else {
                current = current.next;
            }
        }
        // Item not found
        System.out.println("Invalid itemId!");
    }

    // ===== Deletion ======

    // Removing element by Item ID
    public void delete(int itemId){
        // Create references
        Node current = head;
        Node previous = null;
        // Check head
        if(current != null && current.itemId == itemId){
            head = current.next;
            System.out.println("Item removed for item id " + itemId);
            return;
        }
        // Traverse the list
        while(current != null){
            // If item found, remove it and return
            if(current.itemId == itemId){
                previous.next = current.next;
                System.out.println("Item removed for itme id " + itemId);
                return;
            } else {
                previous = current;
                current = current.next;
            }
        }
        // Not found
        System.out.println("Invalid itemId!");
    }

    // ===== Sorting =====

    // Sorting the list in Ascending order by Price
    public void sortAscendingPrice() {
        // Check for List is empty or has only one element
        if (head == null || head.next == null) {
            return;
        }

        // Perform sorting using bubble sort
        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            Node previous = null;
            while (current != null && current.next != null) {
                // Check the condition
                if (current.price > current.next.price) {
                    // Swap nodes
                    Node temp = current.next;
                    current.next = temp.next;
                    temp.next = current;
                    if (previous == null) {
                        // Update head to temp
                        head = temp;
                    } else {
                        // Update previous.next
                        previous.next = temp;
                    }
                    // Update swapped and previous
                    swapped = true;
                    previous = temp;
                } else {
                    previous = current;
                    current = current.next;
                }
            }
        } while (swapped);
    }

    // Sort the list in descending order by Price
    public void sortDescendinPrice() {
        // Check for List is empty or has only one element
        if (head == null || head.next == null) {
            return;
        }

        // Perform sorting
        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            Node previous = null;
            while (current != null && current.next != null) {
                // Check the condition
                if (current.price < current.next.price) {
                    // Swap nodes
                    Node temp = current.next;
                    current.next = temp.next;
                    temp.next = current;
                    // Check and Update the head or previous
                    if (previous == null) {
                        head = temp;
                    } else {
                        previous.next = temp;
                    }
                    //  Update the value of swapped and previous
                    swapped = true;
                    previous = temp;
                } else {
                    previous = current;
                    current = current.next;
                }
            }
        } while (swapped);
    }

    // Sort the list in ascending order by name
    public void sortByNameAscending() {
        // Check for List is empty or has only one element
        if (head == null || head.next == null) {
            return;
        }

        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            Node previous = null;
            while (current != null && current.next != null) {
                // Check the conditions
                if (current.itemName.compareTo(current.next.itemName) > 0) {
                    // Swap nodes
                    Node temp = current.next;
                    current.next = temp.next;
                    temp.next = current;
                    // Check and update head or previous
                    if (previous == null) {
                        head = temp;
                    } else {
                        previous.next = temp;
                    }
                    // Update the value of swapped and previous
                    swapped = true;
                    previous = temp;
                } else {
                    previous = current;
                    current = current.next;
                }
            }
        } while (swapped);
    }

    // Sort the list in descending order by name
    public void sortByNameDescending() {
        // Check for List is empty or has only one element
        if (head == null || head.next == null) {
            return;
        }

        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            Node previous = null;
            while (current != null && current.next != null) {
                // Check the condition
                if (current.itemName.compareTo(current.next.itemName) < 0) {
                    // Swap nodes
                    Node temp = current.next;
                    current.next = temp.next;
                    temp.next = current;
                    // Check and update head or previous
                    if (previous == null) {
                        head = temp;
                    } else {
                        previous.next = temp;
                    }
                    // Update the value of swapped and previous
                    swapped = true;
                    previous = temp;
                } else {
                    previous = current;
                    current = current.next;
                }
            }
        } while (swapped);
    }

    // Calculate the total value of the inventory
    public double calculateTotalValue() {
        double totalValue = 0.0;
        Node current = head;
        while (current != null) {
            totalValue += current.price * current.quantity;
            current = current.next;
        }
        return totalValue;
    }

    // ===== Display =====

    public void displayList(){
        // Creating a reference
        Node current = head;
        // Traversing the list
        while(current != null) {
            // Displaying the details
            System.out.println("Item Id: " + current.itemId + "\nItem Name: " + current.itemName + "\nPrice: " + current.price + "\nQuantity: " + current.quantity + "\nTotal: " + (current.price * current.quantity));
            System.out.println();
            current = current.next;
        }
        // Calculating the total value of inventory
        System.out.println("Total Bill: " + calculateTotalValue());
    }
}
