package other;

public class _55_跳跃游戏 {
    public static boolean canJump(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count < 0) {
                return false;
            }
            if (count >= nums.length - i - 1) {
                return true;
            }
            if (count <= nums[i]) {
                count = nums[i];
            }
            count--;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
    }
}
