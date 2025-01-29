package problemsforstacksandqueues.sortstackusingrecursion;

public class Main {
    public static void main(String[] args) {
        SortStack stack = new SortStack();

        // Enqueue
        stack.enqueue(5);
        stack.enqueue(7);
        stack.enqueue(8);
        stack.enqueue(2);

        // Queue after enqueue
        System.out.println("\nStack before sort: ");
        stack.display();
        System.out.println();

        // Sorting
        stack.sortStack(stack.stack);

        // Queue after dequeue
        System.out.println();
        System.out.println("Stack after sort: ");
        stack.display();
    }
}
