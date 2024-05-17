package other;

import java.util.Arrays;

public class _26_删除有序数组的重复项 {
    /**
     * 数组接受法
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int count = 1;
        int[] newNums = new int[nums.length];
        newNums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (newNums[count - 1] < nums[i]) {
                newNums[count] = nums[i];
                count++;
            }
        }
        for (int i = 0; i < count; i++) {
            nums[i] = newNums[i];
        }

        return count;
    }

    /**
     * 双指针解法
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates1(int[] nums) {

        int right = 0;
        int left = 0;
        int count = 1;
        int length = nums.length;
        while (right < length) {
            if (nums[left] < nums[right]){
                ++left;
                nums[left] = nums[right];
                count++;
            }
            right++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] ints = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates1(ints));
        System.out.println(Arrays.toString(ints));

    }
}
