package hot100.binarysearch;

/**
 * @author yinjie
 * @date 2024-05-17 16:11
 */
public class _33_搜索旋转排序数组 {
    /**
     * 思路：主要是利用了，进行旋转之后，对数组进行分两半处理，其中一半必定是有序的特点
     * 1. 首先判断左边是否有序
     * 有序：判断在不在里面，不在直接左指针放在右半数组
     * 无序，那么右边肯定有序，和上面同理
     * 2. 然后在之前判断一下 mid 是否命中即可
     *
     * @param nums   反转后的数组
     * @param target 数组中的目标值
     * @return 目标值所在的索引，不存在为 -1
     */
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return target == nums[0] ? 0 : -1;
        }

        int left = 0;
        int right = nums.length - 1;

        // 左指针大于右指针直接退出
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (mid == nums.length - 1) {
                return nums[mid] == target ? mid : -1;
            }
            // 左边有序
            if (nums[left] <= nums[mid]) {
                // 如果小于左边的最小值，肯定在右边
                if (nums[left] > target || nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            } else {
                // 右边有序，且不在右边数组
                if (nums[mid + 1] > target || nums[right] < target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
