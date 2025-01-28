package doublylinkedlist.librarymanagementsystem;

public class Node {
    String bookTitle, author, genre;
    int id;
    boolean availabilityStatus;
    Node next, prev;

    Node(String bookTitle, String author, String genre, int id, Boolean availabilityStatus){
        this.bookTitle = bookTitle;
        this.author = author;
        this.genre = genre;
        this.id = id;
        this.availabilityStatus = true;
        this.next = this.prev = null;
    }
}
