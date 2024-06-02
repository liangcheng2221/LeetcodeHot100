package hot100.binarysearch;

/**
 * @author yinjie
 * @date 2024-05-17 16:11
 */
public class _33_搜索旋转排序数组 {
    // TODO 还是有点难度，不知道是不是因为很久没刷算法题了。
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
            if (nums[mid] == target){
                return mid;
            }
            // 左边有序
            if (nums[left] <= nums[mid]) {
                if (nums[left] < target){
                    right = mid - 1;
                }else {
                    left = mid;
                }
            } else {
                // 右边有序，且不在右边数组
                if (nums[mid] > target){
                    right = mid - 1;
                }else {
                    left = mid;
                }
            }
        }
        return -1;
    }
}
