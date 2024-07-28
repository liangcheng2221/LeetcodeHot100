package hot100.dynamicprogramming;

import java.util.Arrays;

/**
 * @author yinjie
 * @date 2024-07-27 10:23
 */
public class _198_打家劫舍 {
    /**
     * 一维动态规划
     *
     * @param nums 数组
     * @return 能抢到的最多的钱
     */
    public int rob(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        System.out.println(Arrays.toString(dp));

        return dp[nums.length - 1];
    }
}
