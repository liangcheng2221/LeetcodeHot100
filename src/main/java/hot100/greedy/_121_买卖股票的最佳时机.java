package hot100.greedy;

import java.util.Stack;

/**
 * @author <a href="https://github.com/liangcheng2221">yinjie</a>
 * @date 2024-07-12 8:47
 */
public class _121_买卖股票的最佳时机 {

    /**
     * 单调栈的解题思路
     *
     * @param prices 价格数组
     * @return 返回最大利润
     */
    public int maxProfit(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int price : prices) {
            if (stack.isEmpty()) {
                stack.push(price);
                continue;
            }
            if (price <= stack.peek()) {
                stack.push(price);
                continue;
            }
            Integer pop = stack.pop();
            max = Math.max(max, price - pop);
            stack.push(price);
            stack.push(pop);
        }
        return max;
    }
    /**
     * 基于单调栈的优化
     *
     * @param prices 价格数组
     * @return 返回最大利润
     */
    public int maxProfitByGreedy(int[] prices) {
        int tempMin = Integer.MAX_VALUE;
        int max = 0;

        for (int price : prices){
            // 遇到小的就交换，否则依旧记录最大值
            if (tempMin > price){
                tempMin = price;
            }else {
                max = Math.max(max,price - tempMin);
            }
        }


        return max;
    }
}
