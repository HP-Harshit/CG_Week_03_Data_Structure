package singlelinkedlist.studentrecordmanagement;

public class LinkedList {

    private Node head;

    public LinkedList(){
        this.head = null;
    }

    // ===== Insertion =====

    // Adding element at the end
    public void addAtEnd(int rollNumber, String name, int age, String grade){
        Node newNode = new Node(rollNumber, name, age, grade);
        if(head == null){
            head = newNode;
            System.out.println("Record Added");
        } else {
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
            System.out.println("Record Added");
        }
    }

    // Adding element at the Beginning
    public void addAtBeginning(int rollNumber, String name, int age, String grade){
        Node newNode = new Node(rollNumber, name, age, grade);
        newNode.next = head;
        head = newNode;
        System.out.println("Record Added");
    }

    // Adding element at the Specific Position
    public void addAtIndex(int rollNumber, String name, int age, String grade, int index){
        Node newNode = new Node(rollNumber, name, age, grade);
        if(index == 0){
            addAtBeginning(rollNumber, name, age, grade);
            System.out.println("Record Added");
            return;
        }
        int position = 0;
        Node current = head;
        Node previous = null;
        while(current.next != null && position < index){
                previous = current;
                current = current.next;
                position++;
        }
        if(position == index){
            previous.next = newNode;
            newNode.next = current;
            System.out.println("Record Added");
        } else {
            System.out.println("Invalid index!");
        }
    }


    // ===== Search =====

    public void search(int rollNumber){
        Node current = head;
        while(current != null){
            if(rollNumber == current.rollNumber){
                System.out.println("Record found");
                System.out.println("Rollnumber: " + current.rollNumber);
                System.out.println("Name: " + current.name);
                System.out.println("Age: " + current.age);
                System.out.println("Grade: " + current.grade);
                return;
            } else {
                current = current.next;
            }
        }
        System.out.println("Record not found!");
    }


    // ===== Update =====

    public void update(int rollNumber, String grade){
        Node current = head;
        while(current != null){
            if(current.rollNumber == rollNumber){
                current.grade = grade;
                System.out.println("Grade Updated");
                return;
            } else {
                current = current.next;
            }
        }
        System.out.println("Invalid rollNumber!");
    }

    // ===== Deletion ======

    // Adding element at the end
    public void delete(int rollNumber){
        Node current = head;
        Node previous = null;
        if(current != null && current.rollNumber == rollNumber){
            head = current.next;
            System.out.println("Deleted Record for rollNumber " + rollNumber);
            return;
        }
        while(current != null){
            if(current.rollNumber == rollNumber){
                previous.next = current.next;
                System.out.println("Deleted Record for rollNumber" + rollNumber);
                return;
            } else {
            previous = current;
            current = current.next;
            }
        }
        System.out.println("Invalid rollNumber!");
    }

    // ===== Display =====

    public void displayList(){
        Node current = head;
        System.out.println("RollNumber\tName\tAge\tGrade");
        while(current != null) {
            System.out.println("\t" + current.rollNumber + "\t\t" + current.name + "\t" + current.age + "\t" + current.grade);
            current = current.next;
        }
    }
}
