package hot100.dynamicprogramming;

import java.util.Arrays;

/**
 * @author <a href="https://github.com/liangcheng2221">yinjie</a>
 * @date 2024-08-03 8:50
 */
public class _322_零钱兑换 {
    /**
     * dp[j] 代表总金额为 j 所需的 最少的硬币个数
     *
     * @param coins  硬币数组
     * @param amount 金额数目
     * @return 返回使用的最少硬币个数
     */
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                // 只有当有最小个数的时候才进行赋值
                if (dp[j - coin] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j - coin] + 1, dp[j]);
                }
            }
        }
        System.out.println(Arrays.toString(dp));

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
