package circularlinkedlist.taskscheduler;

public class CircularLinkedList {

    // Head and Tail Nodes
    private Node head, tail;

    public CircularLinkedList() {
        this.head = this.tail = null;
    }

    // ===== Insertion =====

    // Adding a task at the end
    public void addAtEnd(int taskId, String taskName, int priority, String dueDate) {
        // Create a new node
        Node newNode = new Node(taskId, taskName, priority, dueDate);

        // Check for empty list
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head; // Make it circular
            System.out.println("Task Added at the End");
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head; // Maintain circular nature
            System.out.println("Task Added at the End");
        }
    }

    // Adding a task at the beginning
    public void addAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        // Create a new node
        Node newNode = new Node(taskId, taskName, priority, dueDate);

        // Check for empty list
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head; // Make it circular
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head; // Maintain circular nature
        }
        System.out.println("Task Added at the Beginning");
    }

    // Adding a task at a specific position
    public void addAtIndex(int taskId, String taskName, int priority, String dueDate, int index) {
        // Create a new node
        Node newNode = new Node(taskId, taskName, priority, dueDate);

        // If index is zero, add at the beginning
        if (index == 0) {
            addAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }

        Node current = head;
        int position = 0;

        // Traverse to the specific index
        while (current.next != head && position < index -1) {
            current = current.next;
            position++;
        }

        // If position is correct, add the new node
        if (position == index -1) {
            newNode.next = current.next;
            current.next = newNode;
            System.out.println("Task Added at Index " + index);
        } else {
            // If index is out of bounds
            System.out.println("Invalid Index!");
        }
    }

    // ===== Deletion =====

    // Removing a task by Task ID
    public void removeById(int taskId) {
        // Check if list is empty
        if (head == null) {
            System.out.println("The list is empty!");
            return;
        }

        // If head needs to be removed
        if (head.taskId == taskId) {
            if (head == tail) { // Only one node
                head = tail = null;
            } else {
                head = head.next;
                tail.next = head; // Maintain circular nature
            }
            System.out.println("Task Removed: ID = " + taskId);
            return;
        }

        // Traverse to find the node to remove
        Node current = head;
        Node previous = null;
        while (current.next != head && current.taskId != taskId) {
            previous = current;
            current = current.next;
        }

        // If node found
        if (current.taskId == taskId) {
            previous.next = current.next;
            // If tail is removed
            if (current == tail) {
                tail = previous;
                tail.next = head; // Maintain circular nature
            }
            System.out.println("Task Removed: ID = " + taskId);
        } else {
            System.out.println("Task Not Found: ID = " + taskId);
        }
    }

    // ===== View Current Task and Move to Next Task =====

    // Display the current task and move to the next
    public void viewAndMoveToNext() {
        // Check if the list is empty
        if (head == null) {
            System.out.println("The list is empty!");
            return;
        }

        // Display the current task
        System.out.println("Current Task: ");
        System.out.println("Task ID: " + head.taskId);
        System.out.println("Task Name: " + head.taskName);
        System.out.println("Priority: " + head.priority);
        System.out.println("Due Date: " + head.dueDate);

        // Move to the next task
        head = head.next;
        tail.next = head; // maintain circular nature
    }

// ===== Search =====

    // Search tasks by priority
    public void searchByPriority(int priority) {
        // Create a reference node
        Node current = head;

        // Check if the list is empty
        if (current == null) {
            System.out.println("The list is empty!");
            return;
        }

        // Traverse the list
        do {
            // If item found
            if (current.priority == priority) {
                System.out.println("Task found:");
                System.out.println("Task ID: " + current.taskId);
                System.out.println("Task Name: " + current.taskName);
                System.out.println("Priority: " + current.priority);
                System.out.println("Due Date: " + current.dueDate);
                return;
            }
            current = current.next;
        } while (current != head);

        // Item not found
        System.out.println("Task with priority " + priority + " not found!");
    }

// ===== Display =====

    // Display all tasks in the list starting from head
    public void displayTasks() {
        // Create a reference node
        Node current = head;

        // Check if the list is empty
        if (head == null) {
            System.out.println("The list is empty!");
            return;
        }

        // Traverse the list and print details
        do {
            System.out.println("Task ID: " + current.taskId + ", Task Name: " + current.taskName +
                    ", Priority: " + current.priority + ", Due Date: " + current.dueDate);
            current = current.next;
        } while (current != head);
    }
}

