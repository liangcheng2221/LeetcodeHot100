package hot100.greedy;

/**
 * @author yinjie
 * @date 2024-07-12 9:55
 */
public class _45_跳跃游戏2 {
    public static void main(String[] args) {
        System.out.println(jump(new int[]{1,2,3}));
    }

    public static int jump(int[] nums) {
        if (nums.length == 1){
            return 0;
        }
        int count = 1;
        int max = nums[0];
        int maxIndex = 0;
        while ((maxIndex + max) < nums.length - 1) {
            int maxIndex1 = maxIndex;
            int max1 = max;
            for (int j = maxIndex1; j <= max1 + maxIndex1; j++) {
                // 如果碰见大的记录一下，并且跟换最大值
                if (nums[j] > max){
                    maxIndex = j;
                    max = nums[j];
                }
                max--;
            }
            max = nums[maxIndex];
            count++;
        }
        return count;
    }
}
