package problemsforstacksandqueues.implementaqueueusingstacks;

import java.util.Stack;

public class QueueUsingStack {
    // Two stacks used to implement the queue
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    // Enqueue operation to add an element to the queue
    void enqueue(int data) {
        // Push the element onto stack1
        stack1.push(data);
        System.out.println("Enqueue: " + data);
    }

    // Dequeue operation to remove an element from the queue
    int dequeue() {
        // If both stacks are empty, the queue is empty
        if (stack1.empty() && stack2.empty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        // If stack2 is empty, transfer elements from stack1 to stack2
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        // Pop the top element from stack2, which is the front of the queue
        int data = stack2.pop();
        System.out.println("Dequeue element: " + data);
        return data;
    }

    // Display the current elements in the queue
    void display() {
        // If both stacks are empty, the queue is empty
        if (stack1.empty() && stack2.empty()) {
            System.out.println("Queue is empty!");
            return;
        }
        // Transfer elements from stack2 back to stack1 for display
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        // Print elements from stack1, which now contains the queue elements in order
        for (int data : stack1) {
            System.out.print(data + " ");
        }
    }
}
