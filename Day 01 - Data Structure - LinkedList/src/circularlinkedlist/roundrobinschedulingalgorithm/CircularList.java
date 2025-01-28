package circularlinkedlist.roundrobinschedulingalgorithm;

public class CircularList {

        private Node head, tail;
        private Node current;
        private int size;

        public CircularList() {
            this.head = this.tail = this.current = null;
            this.size = 0;
        }

        // ===== Insertion =====

        // Adding an element at the end
        public void addAtEnd(int processId, int burstTime, int priority) {
            Node newNode = new Node(processId, burstTime, priority);

            if (head == null) {
                head = tail = newNode;
                tail.next = head; // Circular
            } else {
                tail.next = newNode;
                tail = newNode;
                tail.next = head; // Maintain circular nature
            }
            size++;
            System.out.println("Process Added");
        }

        // ===== Deletion =====

        // Remove a process by Process ID after its execution
        public void delete(int processId) {
            if (head == null) {
                return;
            }

            Node current = head;
            Node previous = tail;

            // Traverse the list
            do {
                if (current.processId == processId) {
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
                    System.out.println("Process Removed: " + processId);
                    return;
                }
                previous = current;
                current = current.next;
            } while (current != head);
        }

        // ===== Scheduling =====

        // Simulate Round-Robin scheduling
        public void roundRobin(int timeQuantum) {
            if (head == null) {
                System.out.println("No processes to schedule.");
                return;
            }

            Node current = head;
            int time = 0;
            System.out.println("Starting Round-Robin Scheduling");

            // Execute processes in Round-Robin manner
            do {
                if (current.burstTime > 0) {
                    System.out.println("Executing Process ID: " + current.processId);
                    if (current.burstTime > timeQuantum) {
                        current.burstTime -= timeQuantum;
                        time += timeQuantum;
                    } else {
                        time += current.burstTime;
                        current.burstTime = 0;
                        delete(current.processId); // Remove process once executed
                    }
                }
                current = current.next;
            } while (size > 0);
        }

        // ===== Display =====

        // Display all processes in the list
        public void displayProcesses() {
            if (head == null) {
                System.out.println("No processes in the queue.");
                return;
            }

            Node current = head;
            System.out.println("Current processes in the queue:");

            do {
                System.out.println("Process ID: " + current.processId + ", Burst Time: " + current.burstTime + ", Priority: " + current.priority);
                current = current.next;
            } while (current != head);
        }

        // Calculate and display average waiting time and turn-around time
        public void calculateTimes(int totalProcesses, int totalTime) {
            double avgWaitingTime = (double) totalTime / totalProcesses;
            double avgTurnAroundTime = avgWaitingTime + avgWaitingTime;
            System.out.println("Average Waiting Time: " + avgWaitingTime);
            System.out.println("Average Turn-Around Time: " + avgTurnAroundTime);
        }
    }
