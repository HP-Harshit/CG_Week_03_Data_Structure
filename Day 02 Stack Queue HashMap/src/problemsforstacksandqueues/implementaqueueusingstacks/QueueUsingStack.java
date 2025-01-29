package problemsforstacksandqueues.implementaqueueusingstacks;

import java.util.Stack;

public class QueueUsingStack {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    void enqueue(int data) {
        stack1.push(data);
        System.out.println("Enqueue: " + data);
    }

    int dequeue() {
        if (stack1.empty() && stack2.empty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        int data = stack2.pop();
        System.out.println("Dequeue element: " + data);
        return data;
    }

    void display() {
        if (stack1.empty() && stack2.empty()) {
            System.out.println("Queue is empty!");
            return;
        }
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        for (int data : stack1) {
            System.out.print(data + " ");
        }
    }
}
