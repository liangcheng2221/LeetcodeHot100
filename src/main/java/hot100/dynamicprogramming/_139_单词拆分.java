package hot100.dynamicprogramming;

import java.util.Arrays;
import java.util.List;

/**
 * @author <a href="https://github.com/liangcheng2221">yinjie</a>
 * @date 2024-08-03 8:51
 */
public class _139_单词拆分 {
    /**
     * dp[j] 字符串长度为 j 的是否能被 wordDict 单词列表所组成
     *
     * @param s        字符串
     * @param wordDict 单词列表
     * @return 字符串 s 是否能被 wordDict 单词列表组成
     */
    public boolean wordBreak(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length() + 1];
        Arrays.fill(dp, false);
        dp[0] = true;

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                String substring = s.substring(j, i + 1);
                // 判断 j -> i 的字符串列表中是否存在，并且 dp[j] 是否为 true
                if (wordDict.contains(substring) && dp[j]) {
                    dp[i + 1] = true;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[s.length()];
    }
}
