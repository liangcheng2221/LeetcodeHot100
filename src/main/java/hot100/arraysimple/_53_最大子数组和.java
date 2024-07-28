package hot100.arraysimple;

/**
 * @author <a href="https://github.com/liangcheng2221">yinjie</a>
 * @date 2024-05-06 8:49
 */
public class _53_最大子数组和 {
    /**
     * 普通解法：TODO 贪心算法，重新刷了一遍还是没做出来
     *
     * @param nums 数组
     * @return 最大子数组和
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int count = nums[0];
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            max = Math.max(count, max);
            if (count < 0) {
                continue;
            } else {
                count += num;
            }
        }
        return max;
    }
}
