package other;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class _169_多数元素 {
    public static int majorityElement(int[] nums) {
        int count = 0;
        int flag = 0;
        for (int i = 0; i < nums.length; i++) {
            count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (count > nums.length / 2){
                return  nums[i];
            }
        }
        return count;
    }
    public static int majorityElement1(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i : nums){
            if (!hashMap.containsKey(i)){
                hashMap.put(i,1);
            }else {
                hashMap.put(i,hashMap.get(i)+1);
            }
        }
        AtomicInteger count = new AtomicInteger();
        hashMap.forEach((key,value)->{
            if (value > nums.length/2){
                count.set(key);
            }
        });
        return count.get();
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        int result = majorityElement1(nums);
        System.out.println("多数元素是：" + result);
    }
}

