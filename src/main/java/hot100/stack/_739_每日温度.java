package hot100.stack;

import javax.print.DocFlavor;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author <a href="https://github.com/liangcheng2221">yinjie</a>
 * @date 2024-06-05 10:15
 */
public class _739_每日温度 {
    /**
     * 单调栈的思路：如果大的放在最下面，就是判断距离右边比他大的是多少。注意：这里需要循环判断出栈元素，直到比弹出元素小为止
     *
     * @param temperatures 每日温度数组
     * @return 返回目标数组
     */
    public int[] dailyTemperatures(int[] temperatures) {

        // 默认会初始化为零，所以最后剩余的肯定都是没有最大的值
        int[] result = new int[temperatures.length];
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                Integer pop = stack.pop();
                result[pop] = i - pop;
            }
            stack.push(i);
        }

        return result;
    }
}
