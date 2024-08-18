package hot100.dynamicprogramming;

import java.util.Arrays;

/**
 * @author <a href="https://github.com/liangcheng2221">yinjie</a>
 * @date 2024-08-04 11:20
 */
public class _300_最长递增子序列 {
    /**
     * dp[j] 代表 以 nums[j] 为结尾的最大自增子序列长度 dp[j] = max(dp[j],dp[i] + 1)
     * <p>
     * todo 还有一种方法是贪心 + 二分查找
     *
     * @param nums 数组
     * @return 返回最大递增子序列的长度
     */
    public int lengthOfLIS(int[] nums) {

        int length = nums.length;

        int[] dp = new int[length];
        Arrays.fill(dp, 1);

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int max = 0;

        for (int i = 0; i < length; i++) {
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
