package doublylinkedlist.moviemanagementsystem;

public class Node {
    String movieTitle, director;
    int yearOfRelease;
    double rating;
    Node next, prev;

    Node(String movieTitle, String director, int yearOfRelease, double rating){
        this.movieTitle = movieTitle;
        this.director = director;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
        this.next = this.prev = null;
    }
}
