package hot100.dynamicprogramming;

import java.util.Arrays;

/**
 * @author <a href="https://github.com/liangcheng2221">yinjie</a>
 * @date 2024-07-27 10:24
 */
public class _279_完全平方数 {
    /**
     * d[j] 代表和为 j 的完全平方数的最小数量
     *
     * @param n 和
     * @return 最小数量
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // 循环遍历每一个数，这个数的平方数一定要小于n
        for (int i = 1; i * i <= n; i++) {
            // 循环遍历每一个平方数
            for (int j = i * i; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        return dp[n];
    }
}
