package hot100.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author <a href="https://github.com/liangcheng2221">yinjie</a>
 * @date 2024-05-07 10:06
 */
public class _22_括号生成 {
    /**
     * TODO 这个有点抽象，两重回溯有点难搞
     *
     * @param n 括号的组数
     * @return 返回满足要求的列表
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(new StringBuilder(), result, n, 0, 0);
        return result;
    }

    private void dfs(StringBuilder stringBuilder, List<String> result, int n, int open, int close) {
        if (stringBuilder.length() == n * 2) {
            result.add(stringBuilder.toString());
            return;
        }

        if (open < n) {
            stringBuilder.append("(");
            dfs(stringBuilder, result, n, open + 1, close);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        if (close < open) {
            stringBuilder.append(")");
            dfs(stringBuilder, result, n, open, close + 1);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }


    }
}
