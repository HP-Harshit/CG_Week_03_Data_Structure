package circularlinkedlist.onlineticketreservationsystem;

public class Main {

    public static void main(String[] args) {
        // Create a new circular linked list for ticket reservations
        CircularLinkedList ticketList = new CircularLinkedList();

        // Add new ticket reservations
        ticketList.addTicket(1, "John", "The Matrix", 12, "2025-01-28 18:30");
        ticketList.addTicket(2, "Charlie", "Inception", 15, "2025-01-28 19:00");
        ticketList.addTicket(3, "Alice", "The Matrix", 18, "2025-01-28 19:30");
        ticketList.addTicket(4, "Bob", "Avatar", 20, "2025-01-28 20:00");
        System.out.println();

        // Display all tickets
        System.out.println("All tickets:");
        ticketList.displayTickets();
        System.out.println();

        // Remove a ticket by Ticket ID
        System.out.println("\nRemoving ticket with ID 3:");
        ticketList.removeTicket(3);
        System.out.println();

        // Display all tickets after removal
        System.out.println("\nAll tickets after removal:");
        ticketList.displayTickets();
        System.out.println();

        // Search for a ticket by Customer Name
        System.out.println("\nSearching for tickets by customer name 'Jane Smith':");
        ticketList.searchByCustomerName("Bob");
        System.out.println();

        // Search for a ticket by Movie Name
        System.out.println("\nSearching for tickets by movie name 'The Matrix':");
        ticketList.searchByMovieName("The Matrix");
        System.out.println();

        // Calculate the total number of booked tickets
        System.out.println("\nTotal number of booked tickets:");
        ticketList.totalBookedTickets();
    }
}
