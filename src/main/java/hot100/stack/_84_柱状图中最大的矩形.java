package hot100.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author yinjie
 * @date 2024-06-06 13:27
 */
public class _84_柱状图中最大的矩形 {
    /**
     * 思路：
     * 1.首先记录左右两边比当前元素小的元素的索引差大小
     * 2.将栈中元素与边缘元素索引差大小
     * 3.遍历一次记录最大值
     *
     * @param heights 数组
     * @return 返回柱状图中最大的矩形
     */
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] right = new int[heights.length];
        int[] left = new int[heights.length];
        int max = Integer.MIN_VALUE;
        // 记录左边比它大的数
        for (int i = 0; i < heights.length; i++) {
            while (!deque.isEmpty() && heights[i] < heights[deque.peek()]) {
                int top = deque.pop();
                right[top] = i - top;
            }
            deque.push(i);
        }

        // 记录留在栈里面的索引
        while (!deque.isEmpty()) {
            Integer pop = deque.pop();
            right[pop] = heights.length - pop;
        }

        // 记录右边比它大的数
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!deque.isEmpty() && heights[i] < heights[deque.peek()]) {
                Integer top = deque.pop();
                left[top] = top - i;
            }
            deque.push(i);
        }

        // 记录留在栈里面的索引
        while (!deque.isEmpty()) {
            Integer pop = deque.pop();
            left[pop] = pop + 1;
        }

        // 记录最大值
        for (int i = 0; i < heights.length; i++) {
            max = Math.max((right[i] + left[i] - 1) * heights[i], max);
        }
        return max;
    }
}
