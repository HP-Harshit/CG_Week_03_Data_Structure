package circularlinkedlist.roundrobinschedulingalgorithm;

public class Main {

    public static void main(String[] args) {
        // Create a new circular linked list
        CircularList roundRobin = new CircularList();

        // Add processes to the list
        roundRobin.addAtEnd(1, 10, 1);
        roundRobin.addAtEnd(2, 15, 2);
        roundRobin.addAtEnd(3, 20, 1);
        roundRobin.addAtEnd(4, 5, 3);
        roundRobin.addAtEnd(5, 10, 2);
        System.out.println();

        // Display all processes
        System.out.println("Processes in the list:");
        roundRobin.displayProcesses();
        System.out.println();

        // Simulate Round-Robin scheduling with a time quantum of 5
        System.out.println("\nStarting Round-Robin scheduling:");
        roundRobin.roundRobin(5);
        System.out.println();

        // Display all processes after scheduling
        System.out.println("\nProcesses after scheduling:");
        roundRobin.displayProcesses();
        System.out.println();

        // Calculate and display average waiting time and turn-around time
        int totalProcesses = 5; // Number of processes initially added
        int totalTime = 60; // Total time for demonstration purposes
        roundRobin.calculateTimes(totalProcesses, totalTime);
    }
}
