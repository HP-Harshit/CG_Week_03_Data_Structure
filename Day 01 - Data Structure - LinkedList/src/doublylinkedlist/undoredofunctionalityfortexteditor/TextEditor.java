package doublylinkedlist.undoredofunctionalityfortexteditor;

public class TextEditor {
    private Node head, tail, current;
    private int size;
    private final int MAX_HISTORY;

    public TextEditor(int maxHistory) {
        this.head = this.tail = this.current = null;
        this.size = 0;
        this.MAX_HISTORY = maxHistory;
    }

    // ===== Add a new text state =====
    public void addTextState(String text) {
        Node newNode = new Node(text);

        if (head == null) {
            head = tail = current = newNode;
        } else if (current == tail) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            current = newNode;
        } else {
            // We are in undo state; add new state after current and clear redo history
            current.next = newNode;
            newNode.prev = current;
            tail = newNode;
            current = newNode;
        }

        // Maintain max history size
        if (size == MAX_HISTORY) {
            head = head.next;
            head.prev = null;
        } else {
            size++;
        }
        System.out.println("Text State Added: " + text);
    }


    // ===== Undo functionality =====
    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo: " + current.textState);
        } else {
            System.out.println("No more undo operations available.");
        }
    }

    // ===== Redo functionality =====
    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo: " + current.textState);
        } else {
            System.out.println("No more redo operations available.");
        }
    }

    // ===== Display current text state =====
    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current Text State: " + current.textState);
        } else {
            System.out.println("No text state available.");
        }
    }
}

