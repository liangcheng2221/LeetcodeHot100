package other;

import java.util.Arrays;

public class _1929_数组串联 {
    public static int[] getConcatenation(int[] nums) {
        int len = nums.length << 1;
        int[] ints = new int[len];
        for (int i = 0; i < len; i++) {
            ints[i] = nums[i % nums.length];
        }
        return ints;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getConcatenation(new int[]{1, 2, 3, 4, 5})));
    }
}
