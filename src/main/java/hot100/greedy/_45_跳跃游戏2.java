package hot100.greedy;

/**
 * @author <a href="https://github.com/liangcheng2221">yinjie</a>
 * @date 2024-07-12 9:55
 */
public class _45_跳跃游戏2 {
    public static void main(String[] args) {
        System.out.println(jump(new int[]{1, 2, 3}));
    }

    public static int jump(int[] nums) {
        // 如果只有一个元素直接返回
        if (nums.length == 1) {
            return 0;
        }
        // 记录走的次数
        int count = 1;
        // 记录路途中最大值
        int max = nums[0];
        // 记录路途中最大值的索引
        int maxIndex = 0;
        while (maxIndex + max < nums.length - 1) {

            int maxTempIndex = maxIndex;
            int maxTemp = max;
            for (int j = maxTempIndex; j <= maxTemp + maxTempIndex; j++) {
                // 如果碰见大的记录一下，并且跟换最大值
                if (nums[j] > max) {
                    maxIndex = j;
                    max = nums[j];
                }
                max--;
            }
            // 遍历完回到路途中的最大值
            max = nums[maxIndex];
            count++;
        }
        return count;
    }
}
