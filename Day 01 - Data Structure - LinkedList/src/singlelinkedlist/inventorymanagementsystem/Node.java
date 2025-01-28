package singlelinkedlist.inventorymanagementsystem;

public class Node {
    int itemId;
    String itemName;
    int quantity;
    double price;
    Node next;

    public Node(int itemId, String itemName, double price, int quantity) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}
