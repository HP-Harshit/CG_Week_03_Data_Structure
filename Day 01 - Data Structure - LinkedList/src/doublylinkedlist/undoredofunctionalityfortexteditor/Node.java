package doublylinkedlist.undoredofunctionalityfortexteditor;

public class Node {
    String textState;
    Node next;
    Node prev;

    // Constructor to initialize a new node
    public Node(String textState) {
        this.textState = textState;
        this.next = null;
        this.prev = null;
    }
}
