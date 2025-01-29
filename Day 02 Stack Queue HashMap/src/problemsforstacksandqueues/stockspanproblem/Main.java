package problemsforstacksandqueues.stockspanproblem;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // Creating an instance of StockSpan
        StockSpan stockSpan = new StockSpan();

        // Create an array of prices
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] span = stockSpan.calculateSpan(prices);

        // Displaying the result
        System.out.println("Prices: " + Arrays.toString(prices));
        System.out.println("Span: " + Arrays.toString(span));
    }
}
