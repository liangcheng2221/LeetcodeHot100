package hot100.greedy;

/**
 * @author <a href="https://github.com/liangcheng2221">yinjie</a>
 * @date 2024-07-12 9:26
 */
public class _55_跳跃游戏 {
    public boolean canJump(int[] nums) {
        int min = nums[0];
        int i = 0;
        for (; i < nums.length; i++) {
            if (min > 0 && --min < nums[i]){
                min = nums[i];
                continue;
            }
            if (min <= 0){
                return i == nums.length - 1;
            }
        }
        return true;
    }
}
