package problemsforstacksandqueues.circulartourproblem;

public class Main {
    public static void main(String[] args) {
        // Create an array of petrol pumps with petrol amount and distance to the next pump
        PetrolPump[] pumps = {
                new PetrolPump(6, 4),
                new PetrolPump(3, 6),
                new PetrolPump(7, 3)
        };

        // Create an instance of CircularTour to find the starting petrol pump
        CircularTour tour = new CircularTour();
        int start = tour.findStartingPetrolPump(pumps);

        // Print the result
        if (start != -1) {
            System.out.println("Start at petrol pump index: " + start);
        } else {
            System.out.println("No solution exists.");
        }
    }
}
