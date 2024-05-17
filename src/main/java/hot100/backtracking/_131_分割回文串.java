package hot100.backtracking;

import cn.hutool.core.util.PageUtil;
import cn.hutool.core.util.StrUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yinjie
 * @date 2024-05-09 9:47
 */
public class _131_分割回文串 {
    /**
     * TODO 说实话真的有点太抽象了，根本看不懂，勉强跟着 代码随想录写了一下
     *
     * @param s 目标字符串
     * @return 满足条件的二维数组
     */
    /*
        现在好像有点理解了，首先是从零开始遍历看有没有符合条件（startIndex -> i）的回文串（只要有元素，就肯定有），只要有就直接存储，开始往下判断（判断完回溯）
        终止条件为：只要startIndex不能索引到元素就存储
     */
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        // 存储分割的方案
        List<String> list = new ArrayList<>();
        dfs(result, s, list, 0);
        return result;
    }

    private void dfs(List<List<String>> result, String s, List<String> list, int startIndex) {
        // 分割线到达最后直接存储（如果不符合，startIndex不会到达这）
        if (startIndex == s.length()) {
            result.add(new ArrayList<>(list));
        }

        for (int i = startIndex; i < s.length(); i++) {
            // 不符合回文串的条件直接重新循环
            if (!check(s.substring(startIndex, i + 1))) {
                continue;
            }
            list.add(s.substring(startIndex, i + 1));
            dfs(result, s, list, i + 1);
            // 回溯操作
            list.remove(list.size() - 1);
        }
    }

    private boolean check(String string) {
        if (string == null || string.isEmpty()) {
            return false;
        }
        int left = 0;
        int right = string.length() - 1;


        while (left <= right) {
            if (string.charAt(left) != string.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
