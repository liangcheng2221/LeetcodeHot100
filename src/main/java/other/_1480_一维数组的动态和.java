package other;

import java.util.Arrays;

public class _1480_一维数组的动态和 {
    public static int[] runningSum(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] += count;
            count = nums[i];
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(runningSum(new int[]{1, 2, 3, 4})));
    }
}
