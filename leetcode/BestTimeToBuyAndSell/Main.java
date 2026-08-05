public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }

    public static int maxProfit(int[] prices) {
        int result = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                result += prices[i] - prices[i - 1];
            }
        }

        return result;
    }
}