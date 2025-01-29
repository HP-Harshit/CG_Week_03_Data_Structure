package problemsforstacksandqueues.implementaqueueusingstacks;

public class Main {
    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();

        // Enqueue
        queue.enqueue(5);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(2);

        // Queue after enqueue
        System.out.println("Queue: ");
        queue.display();
        System.out.println();

        // Dequeue
        queue.dequeue();
        queue.dequeue();

        // Queue after dequeue
        System.out.println();
        queue.display();
    }
}
