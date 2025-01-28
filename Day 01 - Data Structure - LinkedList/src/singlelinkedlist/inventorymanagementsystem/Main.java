package singlelinkedlist.inventorymanagementsystem;

public class Main {
    public static void main(String[] args) {
        // Create a new LinkedList instance
        LinkedList inventoryList = new LinkedList();

        // Add items to the inventory
        inventoryList.addAtEnd(1, "Laptop", 1000.00, 10);
        inventoryList.addAtEnd(2, "Mouse", 25.00, 50);
        inventoryList.addAtEnd(3, "Keyboard", 75.00, 30);
        inventoryList.addAtEnd(4, "Tablet", 400.00, 20);
        System.out.println();

        // Display all items in the inventory
        System.out.println("Displaying all items in the inventory:");
        inventoryList.displayList();
        System.out.println();

        // Update the quantity of an item
        System.out.println("\nUpdating quantity for item with ID 2 (Mouse):");
        inventoryList.update(2, 60);
        inventoryList.searchByItemId(2);
        System.out.println();

        // Search for items by Item ID and Name
        System.out.println("\nSearching for item with ID 3:");
        inventoryList.searchByItemId(3);
        System.out.println();

        System.out.println("\nSearching for item with Name 'Tablet':");
        inventoryList.searchByItemName("Tablet");
        System.out.println();

        // Sort the inventory by price in ascending order and display
        System.out.println("\nSorting inventory by price in ascending order:");
        inventoryList.sortAscendingPrice();
        inventoryList.displayList();
        System.out.println();

        // Sort the inventory by price in descending order and display
        System.out.println("\nSorting inventory by price in descending order:");
        inventoryList.sortDescendinPrice();
        inventoryList.displayList();
        System.out.println();

        // Sort the inventory by name in ascending order and display
        System.out.println("\nSorting inventory by name in ascending order:");
        inventoryList.sortByNameAscending();
        inventoryList.displayList();
        System.out.println();

        // Sort the inventory by name in descending order and display
        System.out.println("\nSorting inventory by name in descending order:");
        inventoryList.sortByNameDescending();
        inventoryList.displayList();
        System.out.println();

        // Calculate and display the total value of the inventory
        System.out.println("\nCalculating total inventory value:");
        double totalValue = inventoryList.calculateTotalValue();
        System.out.println("Total Inventory Value: $" + totalValue);
        System.out.println();

        // Remove an item from the inventory
        System.out.println("\nRemoving item with ID 3 (Keyboard):");
        inventoryList.delete(3);
        inventoryList.displayList();
    }
}
