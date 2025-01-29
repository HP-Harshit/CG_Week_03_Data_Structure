package problemsforstacksandqueues.sortstackusingrecursion;

import java.util.Stack;

public class SortStack {
    Stack<Integer> stack = new Stack<>();

    void enqueue(int data){
        stack.push(data);
        System.out.println("Enqueue: " + data);
    }

    void dequeue(){
        if(stack.empty()){
            System.out.println("Queue is empty!");
            return;
        }
        int data = stack.pop();
        System.out.println("Dequeue element: " + data);
    }

    void sortStack(Stack<Integer> stack){
        if(!stack.isEmpty()){
            int data = stack.pop();

            sortStack(stack);

            sortedinsert(stack, data);
        }

    }

    void sortedinsert(Stack<Integer> stack, int data){
        if(stack.isEmpty() || data > stack.peek()){
            stack.push(data);
            return;
        }
        int temp = stack.pop();
        sortedinsert(stack, data);
        stack.push(temp);
    }

    void display(){
        for(int data : stack){
            System.out.print(data + " ");
        }
    }
}
