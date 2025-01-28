package circularlinkedlist.taskscheduler;

public class Main {

    public static void main(String[] args) {
        // Create a new circular linked list
        CircularLinkedList taskList = new CircularLinkedList();

        // Add tasks to the list
        taskList.addAtEnd(1, "Task A", 1, "2025-01-28");
        taskList.addAtBeginning(2, "Task B", 2, "2025-02-01");
        taskList.addAtEnd(3, "Task C", 3, "2025-02-05");
        taskList.addAtIndex(4, "Task D", 2, "2025-02-10", 2);
        taskList.addAtEnd(5, "Task E", 1, "2025-02-20");
        System.out.println();

        // Display tasks in the list
        System.out.println("Tasks in the list:");
        taskList.displayTasks();
        System.out.println();

        // View current task and move to next
        System.out.println("\nView and move to next task:");
        taskList.viewAndMoveToNext();
        taskList.viewAndMoveToNext();  // Repeat as needed
        System.out.println();

        // Search for tasks by priority
        System.out.println("\nSearching for tasks with priority 2:");
        taskList.searchByPriority(2);
        System.out.println();

        // Delete a task
        System.out.println("\nDeleting task with ID 4");
        taskList.removeById(4);
        System.out.println();

        // Display tasks after deletion
        System.out.println("\nTasks after deletion:");
        taskList.displayTasks();
    }
}
