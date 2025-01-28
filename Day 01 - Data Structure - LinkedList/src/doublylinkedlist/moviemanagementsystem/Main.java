package doublylinkedlist.moviemanagementsystem;

public class Main {

    public static void main(String[] args) {
        // Create a new doubly linked list
        DoublyLinkedList movieList = new DoublyLinkedList();

        // Add Bollywood movies to the list
        movieList.addAtEnd("3 Idiots", "Rajkumar Hirani", 2009, 8.4);
        movieList.addAtBeginning("Sholay", "Ramesh Sippy", 1975, 8.2);
        movieList.addAtEnd("Dangal", "Nitesh Tiwari", 2016, 8.4);
        movieList.addAtIndex("Lagaan", "Ashutosh Gowariker", 2001, 8.1, 1);
        movieList.addAtEnd("Gully Boy", "Zoya Akhtar", 2019, 8.0);
        movieList.addAtEnd("Swades", "Ashutosh Gowariker", 2004, 8.2);
        movieList.addAtBeginning("Dilwale Dulhania Le Jayenge", "Aditya Chopra", 1995, 8.0);
        System.out.println();

        // Display list in forward order
        System.out.println("Bollywood Movies in forward order:");
        movieList.displayListForward();
        System.out.println();

        // Display list in backward order
        System.out.println("\nBollywood Movies in backward order:");
        movieList.displayListBackward();
        System.out.println();

        // Search for movies
        System.out.println("\nSearching for movies directed by Ashutosh Gowariker:");
        movieList.searchByDirector("Ashutosh Gowariker");
        System.out.println();

        System.out.println("\nSearching for movies with rating 8.0:");
        movieList.searchByRating(8.0);
        System.out.println();

        // Update movie rating
        System.out.println("\nUpdating rating of Gully Boy to 8.1");
        movieList.update(8.1, "Gully Boy");
        System.out.println();

        // Display list after update
        System.out.println("\nBollywood Movies after rating update:");
        movieList.displayListForward();
        System.out.println();

        // Delete a movie
        System.out.println("\nDeleting movie: Swades");
        movieList.delete("Swades");
        System.out.println();

        // Display list after deletion
        System.out.println("\nBollywood Movies after deletion:");
        movieList.displayListForward();
    }
}
