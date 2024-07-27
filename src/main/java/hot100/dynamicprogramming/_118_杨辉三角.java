package hot100.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author yinjie
 * @date 2024-07-21 10:11
 */
public class _118_杨辉三角 {
    /**
     * 动态规划的解法
     *
     * @param numRows 杨辉三角的行数
     * @return 返回杨辉三角
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);

        // 满足初始条件直接返回
        if (numRows == 1) {
            result.add(Arrays.asList(new Integer[]{1}));
            return result;
        }
        if (numRows == 2) {
            result.add(Arrays.asList(new Integer[]{1}));
            result.add(Arrays.asList(new Integer[]{1, 1}));
            return result;
        }
        result.add(Arrays.asList(new Integer[]{1}));
        result.add(Arrays.asList(new Integer[]{1, 1}));

        // 到达第三层开始计算
        for (int i = 2; i < numRows; i++) {
            // 第 i 层的数组 i+1个元素（这里需要注意细节）
            Integer[] integers = new Integer[i + 1];
            integers[0] = 1;
            integers[i] = 1;
            // 计算第 i 层数组的中间值，从第二个元素开始
            for (int j = 1; j < i; j++) {
                // 第 i - 1 层数组
                List<Integer> temp = result.get(i - 1);
                integers[j] = temp.get(j - 1) + temp.get(j);
            }
            result.add(Arrays.asList(integers));
        }

        return result;
    }
}
