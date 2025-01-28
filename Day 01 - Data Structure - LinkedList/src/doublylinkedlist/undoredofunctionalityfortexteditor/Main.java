package doublylinkedlist.undoredofunctionalityfortexteditor;

public class Main {

    public static void main(String[] args) {
        // Create a new text editor with a maximum history size of 10 states
        TextEditor textEditor = new TextEditor(10);

        // Add text states to the editor
        textEditor.addTextState("Hello");
        textEditor.addTextState("Hello, World");
        textEditor.addTextState("Hello, World!");

        // Display the current state
        System.out.println("\nCurrent state:");
        textEditor.displayCurrentState();

        // Perform undo operations
        textEditor.undo();
        textEditor.undo();

        // Display the current state after undo operations
        System.out.println("\nCurrent state after undo:");
        textEditor.displayCurrentState();

        // Perform redo operations
        textEditor.redo();

        // Display the current state after redo operations
        System.out.println("\nCurrent state after redo:");
        textEditor.displayCurrentState();

        // Add more text states
        textEditor.addTextState("New State 1");
        textEditor.addTextState("New State 2");

        // Exceeding the history limit
        for (int i = 3; i <= 15; i++) {
            textEditor.addTextState("New State " + i);
        }

        // Display the current state after exceeding the history limit
        System.out.println("\nCurrent state after exceeding the history limit:");
        textEditor.displayCurrentState();

        // Perform undo and redo operations to ensure they still work
        textEditor.undo();
        textEditor.undo();
        textEditor.redo();

        // Display the final state
        System.out.println("\nFinal state:");
        textEditor.displayCurrentState();
    }
}
