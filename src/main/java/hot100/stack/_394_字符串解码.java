package hot100.stack;

import java.util.Stack;

/**
 * @author yinjie
 * @date 2024-06-04 13:13
 */
public class _394_字符串解码 {
    /**
     * 这题有点小难，搞糊涂了，下次再看
     *
     * @param s 字符串
     * @return 返回解码后的字符串
     */
    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Integer> stackMulti = new Stack<>();
        Stack<StringBuilder> stackStr = new Stack<>();
        int multi = 0;
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (c == '[') {
                stackMulti.push(multi);
                stackStr.push(result);
                multi = 0;
                result = new StringBuilder();
            } else if (c == ']') {
                int len = stackMulti.pop();
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < len; i++) {
                    stringBuilder.append(result);
                }
                StringBuilder pop = stackStr.pop();
                result = new StringBuilder(pop).append(stringBuilder);
            } else if (c >= '0' && c <= '9') {
                multi = multi * 10 + c - '0';
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
