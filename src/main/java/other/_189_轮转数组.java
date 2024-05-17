package other;

import java.util.Arrays;

public class _189_轮转数组 {
    public static void rotate(int[] nums, int k) {
        int length = nums.length;
        int flag = length - k % length;
        int[] temp = new int[nums.length];

        for (int i = 0; i < length; i++) {
            temp[i] = nums[flag % length];
            flag++;
        }
        for (int i = 0; i < length; i++) {
            nums[i] = temp[i];
        }

    }

    public static void main(String[] args) {
        int[] ints = {1,2};
        rotate(ints, 3);
        System.out.println(Arrays.toString(ints));
    }
}
