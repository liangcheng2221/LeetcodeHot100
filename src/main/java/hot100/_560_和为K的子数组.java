package hot100;

import java.util.HashMap;
import java.util.Map;

public class _560_和为K的子数组 {
    /**
     * 直接暴力枚举
     *
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum(int[] nums, int k) {

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            // 有就++
            if (nums[i] == k) {
                count++;
            }
            int temp = nums[i];
            // 依次循环
            for (int j = i + 1; j < nums.length; j++) {
                temp += nums[j];
                if (temp == k) {
                    count++;
                }
                if (temp > k) {
                    break;
                }
            }
        }
        return count;
    }

    /**
     * 哈希存储+前缀和：记录所有前缀和-k的值，如果找到前缀-k的键，就直接值加上count
     * TODO  暂时还不能理解，先记住吧
     *
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySumByHash(int[] nums, int k) {

        int count = 0;
        int pre = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int num : nums) {
            pre += num;
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraySumByHash(new int[]{2, 2, 1, -1, 4, 0}, 3));
    }
}
