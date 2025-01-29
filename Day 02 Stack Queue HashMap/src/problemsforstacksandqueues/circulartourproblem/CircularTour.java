package problemsforstacksandqueues.circulartourproblem;

import java.util.LinkedList;
import java.util.Queue;

public class CircularTour {
    // Method to find the starting petrol pump index to complete the circular tour
    public int findStartingPetrolPump(PetrolPump[] pumps) {
        int n = pumps.length;
        int totalSurplus = 0;
        int currentSurplus = 0;
        int start = 0;

        Queue<Integer> queue = new LinkedList<>();

        // Iterate through each petrol pump
        for (int i = 0; i < n; i++) {
            totalSurplus += pumps[i].petrol - pumps[i].distance;
            currentSurplus += pumps[i].petrol - pumps[i].distance;

            queue.offer(i);

            // If current surplus is negative, update the starting pump index
            if (currentSurplus < 0) {
                while (!queue.isEmpty() && queue.peek() <= i - n) {
                    queue.poll();
                }
                start = i + 1;
                currentSurplus = 0;
            }
        }

        // Return the starting pump index if the total surplus is non-negative
        return (totalSurplus >= 0) ? start : -1;
    }
}


