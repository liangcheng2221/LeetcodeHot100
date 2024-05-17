package other;

public class _27_移除元素 {
    public static int removeElement(int[] nums, int val) {


        int right = nums.length - 1;
        int left = 0;
        int count = 0;
        while(right >= left){
            if (nums[right] == val){
                right--;
                count++;
                continue;
            }
            if (nums[left] == val){
                nums[left] = nums[right];
                right--;
                count++;
            }
            left++;
        }
        return nums.length - count;
    }

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{1},1));
    }
}
