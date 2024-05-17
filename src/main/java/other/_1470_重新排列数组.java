package other;

import java.util.Arrays;

public class _1470_重新排列数组 {
    public static int[] shuffle(int[] nums, int n) {
        int x = 0;
        int y = n;
        int[] ans = new int[nums.length];
        int index = 0;
        for (int i = 0; i < n; i++) {
            ans[index++]= nums[x++];
            ans[index++]= nums[y++];
        }
        return ans;
    }

    public static void main(String[] args) {


        System.out.println(Arrays.toString(shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3)));

    }
}
