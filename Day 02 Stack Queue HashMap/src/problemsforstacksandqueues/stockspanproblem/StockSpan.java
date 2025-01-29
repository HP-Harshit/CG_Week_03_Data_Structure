package problemsforstacksandqueues.stockspanproblem;

import java.util.Stack;

public class StockSpan {
    // Method to calculate span
    public int[] calculateSpan(int[] prices) {
        int n = prices.length;
        // Declare a new array of length n
        int[] span = new int[n];
        // Declare a stack to keep track of indices
        Stack<Integer> stack = new Stack<>();

        // Calculating span for each day
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }
            span[i] = (stack.isEmpty()) ? (i + 1) : (i - stack.peek());
            // Push the index to stack to keep track
            stack.push(i);
        }

        // Returning the span
        return span;
    }
}
