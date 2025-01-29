package problemsforstacksandqueues.stockspanproblem;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        StockSpan stockSpan = new StockSpan();

        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] span = stockSpan.calculateSpan(prices);

        System.out.println("Prices: " + Arrays.toString(prices));
        System.out.println("Span: " + Arrays.toString(span));
    }
}
