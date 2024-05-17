package hot100.binarysearch;

/**
 * @author yinjie
 * @date 2024-05-16 9:17
 */
public class _34_在排序数组中查找元素的第一个和最后一个位置 {
    /**
     * TODO 这个最后一步并没有进行二分操作 ，题解有一维的做法，题解的二维操作了两次
     *
     * @param nums   数组
     * @param target 目标值
     * @return 返回符合的条件
     */
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};

        if (nums.length == 0) {
            return result;
        }


        int right = nums.length - 1;
        int left = 0;
        int index = 0;
        while (right >= left) {
            index = (right + left) / 2;
            if (nums[index] == target) {
                break;
            }
            if (nums[index] > target) {
                right = index - 1;
            } else {
                left = index + 1;
            }
        }

        // 不存在直接返回指定数组
        if (right < left) {
            return result;
        }

        right = index;
        left = index;

        // 中间向两边扩散
        while (right < nums.length && nums[right] == target) {
            right++;
        }
        while (left > 0 && nums[left] == target) {
            left--;
        }

        return new int[]{left + 1, right - 1};
    }
}
