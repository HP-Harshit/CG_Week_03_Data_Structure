package circularlinkedlist.onlineticketreservationsystem;

public class Node {
    int ticketId;
    String customerName;
    String movieName;
    int seatNumber;
    String bookingTime;
    Node next;

    // Constructor to initialize a new node
    public Node(int ticketId, String customerName, String movieName, int seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null; // Initialize next as null
    }
}
