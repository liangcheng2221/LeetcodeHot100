package hot100.stack;

import java.util.Stack;

/**
 * @author <a href="https://github.com/liangcheng2221">yinjie</a>
 * @date 2024-06-04 13:01
 */
public class _155_最小栈 {
    Stack<Integer> stack =new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    public _155_最小栈() {
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        minStack.push(Math.min(minStack.peek(),val));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
