package hot100;

public class _53_最大子数组和 {
    public static int maxSubArray(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int count = Integer.MIN_VALUE;


        // 起始位置的循环
        for (int i = 0; i < nums.length; i++) {
            // 窗口循环次数
            for (int j = 0; j < nums.length - i; j++) {
                int temp = 0;
                // 窗口内的循环
                for (int k = j; k <= j + i; k++) {
                    temp += nums[k];
                }
                count = Math.max(count, temp);
            }
            count = Math.max(count, nums[i]);
        }

        return count;
    }

    /**
     * 贪心算法：从局部最优找到全局最优
     *
     * @param nums
     * @return
     */
    public static int maxSubArray1(int[] nums) {
        /**
         * 基本思想：想要找出子序列最大和，就必须从头开始计算，如果中间碰到之前和小于零的，肯定直接不要（不然就是和一直递增的）
         * 由于，之前一直都会记录最大值（最后肯定是算的连续子序列的最大值）
         */
        int current = 0;
        int currentSum = 0;
        int beforeSum = 0;
        int maxSum = Integer.MIN_VALUE;


        for (int num : nums) {
            current = num;
            currentSum = beforeSum < 0 ? current : current + beforeSum;
            maxSum = Math.max(maxSum, currentSum);
            beforeSum = currentSum;
        }


        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray1(new int[]{5, -4, 1, -7, 2}));
    }
}
