package other;

public class _122_买卖股票的最佳时机二 {
    public static int maxProfit(int[] prices) {

        int minprice = prices[0];
        int maxprice = prices[0];
        int count = 0;
        int countResult = 0;


        for (int price : prices) {
            // 如果最大值大于后面的直接加上利润 否则最大值后移并记录当前最大值
            if (maxprice > price){
                countResult += count;
                minprice = price;
                maxprice = price;
                count = 0;
            }else {
                maxprice = price;
                count = maxprice-minprice;
            }

        }
        return countResult + count;

    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
