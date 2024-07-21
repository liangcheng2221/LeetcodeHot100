package hot100.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yinjie
 * @date 2024-07-20 21:32
 */
public class _763_划分字母区间 {
    public List<Integer> partitionLabels(String s) {
        int length = s.length();
        // 从头遍历到尾的索引
        int i = 0;
        // 记录局部最大的索引
        int j = 0;
        // 记录之前已经分片的个数总和
        int sum = 0;
        List<Integer> result = new ArrayList<>();
        char[] charArray = s.toCharArray();
        while (i < s.length()) {
            int k;
            // 从后面遍历，与索引为i的元素比较，有直接跳出
            for (k = length - 1; k > i; k--) {
                if (charArray[i] == charArray[k]) {
                    break;
                }
            }
            // 记录一个片段的最大索引位置
            j = Math.max(j, k);
            // 如果最大的索引和开始索引相等直接记录为一个片段
            if (i == j) {
                int count = j + 1 - sum;
                result.add(count);
                sum += + count;
            }
            i++;
        }
        return result;

    }
}
