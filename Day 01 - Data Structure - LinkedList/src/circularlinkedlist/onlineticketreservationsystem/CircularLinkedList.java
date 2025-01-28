package circularlinkedlist.onlineticketreservationsystem;

public class CircularLinkedList {
    private Node head, tail;
    private int size;

    public CircularLinkedList() {
        this.head = this.tail = null;
        this.size = 0;
    }

    // ===== Insertion =====

    // Add a new ticket reservation at the end of the list
    public void addTicket(int ticketId, String customerName, String movieName, int seatNumber, String bookingTime) {
        Node newNode = new Node(ticketId, customerName, movieName, seatNumber, bookingTime);

        if (head == null) {
            head = tail = newNode;
            tail.next = head; // Circular pointer
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head; // Maintain circular nature
        }
        size++;
        System.out.println("Ticket Added: " + ticketId);
    }

    // ===== Deletion =====

    // Remove a ticket by Ticket ID
    public void removeTicket(int ticketId) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        Node current = head;
        Node previous = tail;

        do {
            if (current.ticketId == ticketId) {
                // If head is to be removed
                if (current == head) {
                    head = head.next;
                    tail.next = head; // Maintain circular nature
                } else {
                    previous.next = current.next;
                    if (current == tail) {
                        tail = previous; // Update tail if needed
                        tail.next = head; // Maintain circular nature
                    }
                }
                size--;
                System.out.println("Ticket Removed: " + ticketId);
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);

        System.out.println("Ticket ID not found: " + ticketId);
    }

    // ===== Display =====

    // Display all tickets in the list
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets reserved.");
            return;
        }

        Node current = head;
        System.out.println("Reserved Tickets List:");
        do {
            System.out.println("Ticket ID: " + current.ticketId + ", Customer Name: " + current.customerName + ", Movie Name: " + current.movieName + ", Seat Number: " + current.seatNumber + ", Booking Time: " + current.bookingTime);
            current = current.next;
        } while (current != head);
    }

    // ===== Search =====

    // Search for a ticket by Customer Name
    public void searchByCustomerName(String customerName) {
        if (head == null) {
            System.out.println("No tickets reserved.");
            return;
        }

        Node current = head;
        boolean found = false;
        do {
            if (current.customerName.equalsIgnoreCase(customerName)) {
                System.out.println("Ticket found: Ticket ID = " + current.ticketId + ", Movie Name = " + current.movieName + ", Seat Number = " + current.seatNumber + ", Booking Time = " + current.bookingTime);
                found = true;
            }
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("No tickets found for customer: " + customerName);
        }
    }

    // Search for a ticket by Movie Name
    public void searchByMovieName(String movieName) {
        if (head == null) {
            System.out.println("No tickets reserved.");
            return;
        }

        Node current = head;
        boolean found = false;
        do {
            if (current.movieName.equalsIgnoreCase(movieName)) {
                System.out.println("Ticket found: Ticket ID = " + current.ticketId + ", Customer Name = " + current.customerName + ", Seat Number = " + current.seatNumber + ", Booking Time = " + current.bookingTime);
                found = true;
            }
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("No tickets found for movie: " + movieName);
        }
    }

    // Calculate the total number of booked tickets
    public void totalBookedTickets() {
        System.out.println("Total booked tickets: " + size);
    }
}