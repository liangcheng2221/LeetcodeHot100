package hot100.dynamicprogramming;

import java.util.Arrays;

/**
 * @author <a href="https://github.com/liangcheng2221">yinjie</a>
 * @date 2024-08-04 11:22
 */
public class _152_乘积最大子数组 {
    /**
     * dp[i] 代表 在nums[i] 为结尾的乘积最大子数组值
     *
     * @param nums 数组
     * @return 返回乘积最大子数组值
     */
    public int maxProduct(int[] nums) {

        int length = nums.length;

        int[] dpMax = new int[length];
        int[] dpMin = new int[length];

        dpMax[0] = nums[0];
        dpMin[0] = nums[0];

        for (int i = 1; i < length; i++) {
            dpMax[i] = Math.max(Math.max(nums[i] * dpMax[i - 1], nums[i] * dpMin[i - 1]), nums[i]);
            dpMin[i] = Math.min(Math.min(nums[i] * dpMax[i - 1], nums[i] * dpMin[i - 1]), nums[i]);
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < length; i++) {
            max = Math.max(max, dpMax[i]);
        }

        return max;


    }
}
