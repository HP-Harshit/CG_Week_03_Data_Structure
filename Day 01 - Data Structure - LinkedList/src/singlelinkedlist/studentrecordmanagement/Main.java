package singlelinkedlist.studentrecordmanagement;

public class Main {
    public static void main(String[] args) {
        // Create a new LinkedList instance
        LinkedList studentList = new LinkedList();

        // Add student records at the end of the list
        studentList.addAtEnd(1, "John", 20, "A");
        studentList.addAtEnd(2, "Smith", 22, "B");
        studentList.addAtEnd(3, "Alice", 19, "A");

        // Add a student record at the beginning of the list
        studentList.addAtBeginning(4, "Michael", 21, "B");

        // Add a student record at a specific position in the list
        studentList.addAtIndex(5, "Bob", 20, "C", 2);
        System.out.println();

        // Display all student records
        System.out.println("Displaying all student records:");
        studentList.displayList();
        System.out.println();

        // Search for a student record by Roll Number
        System.out.println("\nSearching for student with Roll Number 3:");
        studentList.search(3);
        System.out.println();

        // Update a student's grade based on their Roll Number
        System.out.println("\nUpdating grade for student with Roll Number 2:");
        studentList.update(2, "A+");
        studentList.search(2);
        System.out.println();

        // Delete a student record by Roll Number
        System.out.println("\nDeleting student with Roll Number 4:");
        studentList.delete(4);
        studentList.displayList();
    }
}
