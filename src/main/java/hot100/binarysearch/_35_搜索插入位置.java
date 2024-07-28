package hot100.binarysearch;

/**
 * @author <a href="https://github.com/liangcheng2221">yinjie</a>
 * @date 2024-05-16 8:16
 */
public class _35_搜索插入位置 {
    /**
     * @param nums   数组
     * @param target 目标值
     * @return 索引
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int index = 0;
        while (left <= right) {
            index = (left + right) / 2;
            if (nums[index] == target) {
                break;
            }
            if (nums[index] < target) {
                left = index + 1;
            } else if (nums[index] > target) {
                right = index - 1;
            }
        }

        // 如果没找到，肯定就是左边的，因为左边的始终大于目标值。
        return left > right ? left : index;
    }
}
