package other;

public class _45_跳跃游戏2 {
    public static int jump(int[] nums) {
        int step = 0;
        int count = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (count >= nums.length - i - 1)
            for (int j = i; j <= count; j++){

            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(jump(new int[]{1,3,1}));
    }
}
