package hot100.binarysearch;

/**
 * @author yinjie
 * @date 2024-06-02 5:56
 */
public class _153_寻找旋转数组的最小值 {
    /**
     * 思路：如果两边都是升序的数组，就是最小的那个就是（要求 log n 的时间复杂度）
     *
     * @param nums 反转后的数组
     * @return 返回数组中的最小值
     */
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (right >= left) {
            int mid = (right + left) / 2;
            if (mid == nums.length - 1) {
                return nums[mid];
            }
            // 左边有序
            if (nums[left] <= nums[mid]) {
                // 右边也有序
                if (nums[mid + 1] <= nums[right]) {
                    return Math.min(nums[mid + 1], nums[left]);
                } else {
                    // 右边无序
                    left = mid + 1;
                }
            } else {
                // 左边无序，直接左边
                right = mid;
            }
        }
        // 这个返回值需不需要都无所谓
        return 0;
    }
}
