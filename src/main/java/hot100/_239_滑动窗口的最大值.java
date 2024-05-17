package hot100;

import java.util.Arrays;

public class _239_滑动窗口的最大值 {
    /**
     * 部分滑动窗口遍历：好像也会超时。TODO 需要用到大顶堆的知识
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0;
        int right = left + k;
        int max = Integer.MIN_VALUE;
        int[] ints = new int[nums.length - k + 1];

        // 找到最大值
        for (int i = 0; i < k; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
        }

        ints[0] = max;
        while (right < nums.length) {
            if (nums[left] == max) {
                right++;
                max = getMax(nums, left, right);
            } else {
                max = Math.max(max, nums[right]);
                right++;
            }

            left++;
            ints[left] = max;
        }
        return ints;
    }

    /**
     * 直接从滑动窗口进行循环取最大值：超时
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindowByEnum(int[] nums, int k) {
        int left = 0;
        int right = left + k;
        int max;
        int[] ints = new int[nums.length - k + 1];

        while (right <= nums.length) {
            // 从窗口中取最大值
            max = getMax(nums, left, right);
            ints[left] = max;

            right++;
            left++;

        }

        return ints;
    }

    private static int getMax(int[] test, int left, int right) {
        int max = Integer.MIN_VALUE;

        for (int i = left; i < right; i++) {
            max = Math.max(test[i], max);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
