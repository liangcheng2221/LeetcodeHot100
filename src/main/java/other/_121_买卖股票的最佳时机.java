package other;

public class _121_买卖股票的最佳时机 {
    public static int maxProfit(int[] prices) {
        int count = 0;
        int min = Integer.MAX_VALUE;

        for (int price : prices) {
            if (price < min) {
                min = price;
            } else {
                count = Math.max(count, price - min);
            }
        }
        return count;

    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
