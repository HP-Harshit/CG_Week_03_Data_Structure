package circularlinkedlist.roundrobinschedulingalgorithm;

public class Node {
    int processId;
    int burstTime;
    int priority;
    Node next;

    // Constructor to initialize a new node
    public Node(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null; // Initialize next as null
    }
}
