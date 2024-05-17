package hot100.backtracking;

import java.util.*;

/**
 * @author yinjie
 * @date 2024-05-06 10:29
 */
public class _17_电话号码的字母组合 {

    public static final Map<Character, String> map = new HashMap() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkf");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    /**
     * 这个凭着自己的理解做出来了，有点进步
     *
     * @param digits 电话号码
     * @return 字母的组合
     */
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        Deque<Character> deque = new ArrayDeque<>();
        dfs(list, digits.toCharArray(), 0, deque);
        return list;
    }

    private void dfs(List<String> list, char[] digits, int depth, Deque<Character> deque) {
        // 电话号码为零，直接返回空
        if (digits.length == 0) {
            return;
        }
        // 当深度达到电话号码的长度直接添加到数组直接返回
        if (depth == digits.length) {
            Deque<Character> deque1 = new ArrayDeque<>(deque);
            char[] chars = new char[digits.length];
            for (int i = 0; i < digits.length; i++) {
                chars[i] = deque1.removeLast();
            }
            list.add(new String(chars));
            return;
        }
        // 根据电话号码的号位取对应的字符数组
        String string = map.get(digits[depth]);
        char[] charArray = string.toCharArray();
        for (char c : charArray) {
            deque.push(c);
            dfs(list, digits, depth + 1, deque);
            deque.pop();
        }
    }
}
