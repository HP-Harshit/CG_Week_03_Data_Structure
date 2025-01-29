package problemsforstacksandqueues.sortstackusingrecursion;

import java.util.Stack;

public class SortStack {
    // Declare a Stack
    Stack<Integer> stack = new Stack<>();

    // Method to enqueue the queue
    void enqueue(int data){
        stack.push(data);
        System.out.println("Enqueue: " + data);
    }

    // Method to dequeue the queue
    void dequeue(){
        // Check for stack isEmpty
        if(stack.empty()){
            System.out.println("Queue is empty!");
            // If empty, return
            return;
        }
        // Variable to hold pop element
        int data = stack.pop();
        System.out.println("Dequeue element: " + data);
    }

    // Method to sort stack
    void sortStack(Stack<Integer> stack){
        // Check for stack isEmpty
        if(!stack.isEmpty()){
            // Pop the top element
            int data = stack.pop();

            // Recursively call sortStack method to Sort remaining stack
            sortStack(stack);

            // Call method to Push the top item back in sorted stack
            sortedinsert(stack, data);
        }
    }

    // Helper method for sortStack method
    void sortedinsert(Stack<Integer> stack, int data){
        // Check if Stack isEmpty or data is greater than stackPeek,
        if(stack.isEmpty() || data > stack.peek()){
            // Push the element
            stack.push(data);
            return;
        }
        // If top is greater, remove the top item and recur
        int temp = stack.pop();
        sortedinsert(stack, data);
        // Put back the top item removed earlier
        stack.push(temp);
    }

    // Method to display the stack
    void display(){
        for(int data : stack){
            System.out.print(data + " ");
        }
    }
}
