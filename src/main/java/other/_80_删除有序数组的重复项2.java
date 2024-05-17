package other;

public class _80_删除有序数组的重复项2 {
    public static int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 1;
        int count = 1;
        while (fast < nums.length){
            if (count == 2){
                slow = fast;
                count = 0;
            }
            if(nums[fast] == nums[fast-1]){
                count++;
            }
            fast++;
        }
        return 1;
    }
}
