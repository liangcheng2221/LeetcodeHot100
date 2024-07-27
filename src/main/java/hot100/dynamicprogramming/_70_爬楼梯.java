package hot100.dynamicprogramming;

/**
 * @author yinjie
 * @date 2024-07-21 10:11
 */
public class _70_爬楼梯 {


    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        if (n == 1 || n == 2) {
            return n;
        }
        dp[1] = 1;
        dp[2] = 2;
        return dynamic(n, dp);
    }

    /**
     * 递归的解法（超出时间限制）
     *
     * @param n 楼梯的长度
     * @return 返回走到楼梯的方法总数
     */
    private int recursion(int n) {

        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        return recursion(n - 1) + recursion(n - 2);
    }

    /**
     * 动态规划的解法
     *
     * @param n 楼梯的长度
     * @return 返回走到楼梯的方法总数
     */
    private int dynamic(int n, int[] dp) {
        if (n == 1 || n == 2) {
            return dp[n];
        }
        for (int i = 3; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }


}
