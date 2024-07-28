package hot100.stack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @author <a href="https://github.com/liangcheng2221">yinjie</a>
 * @date 2024-06-04 12:43
 */
public class _20_有效括号 {
    public static final Map<Character, Character> map = new HashMap<Character, Character>() {{
        put('{', '}');
        put('[', ']');
        put('(', ')');
    }};

    /**
     * 思路：用 map 记录对应的括号，数组元素为键，直接插入，否则判断 是否栈为空或者栈头对应
     *
     * @param s 字符串
     * @return 是否为有效括号
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            // 如果为 map 键，直接入栈
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                // 不是，且栈为空或者栈头不和数组对应直接返回false
                if (stack.isEmpty() || !map.get(stack.pop()).equals(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
