package hot100.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="https://github.com/liangcheng2221">yinjie</a>
 * @date 2024-05-07 10:18
 */
public class _79_单词搜索 {
    /**
     * TODO 这题花的时间是真的多，估计一个多小时，勉强能做出来，不过时间复杂度还是有点高（回溯的操作搞错了）
     *
     * @param board 二维数组
     * @param word  单词字符串
     * @return 是否存在
     */
    public boolean exist(char[][] board, String word) {
        boolean flag = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                StringBuilder stringBuilder = new StringBuilder();
                flag = dfs(board, word, stringBuilder, 0, i, j, new boolean[board.length][board[0].length]);
                System.out.println(stringBuilder);
                if (flag) {
                    return flag;
                }
            }
        }
        return flag;
    }

    private boolean dfs(char[][] board, String word, StringBuilder stringBuilder, int wordIndex, int x, int y, boolean[][] flag) {
        if (stringBuilder.length() == word.length()) {
            return true;
        }
        if (x < 0 || y < 0 || x == board.length || y == board[0].length || x + y < word.length() || flag[x][y]) {
            return false;
        }
        if (word.charAt(wordIndex) == board[x][y]) {
            flag[x][y] = true;
            stringBuilder.append(board[x][y]);
            boolean dfs = dfs(board, word, stringBuilder, wordIndex + 1, x, y + 1, flag);
            boolean dfs1 = dfs(board, word, stringBuilder, wordIndex + 1, x, y - 1, flag);
            boolean dfs2 = dfs(board, word, stringBuilder, wordIndex + 1, x - 1, y, flag);
            boolean dfs3 = dfs(board, word, stringBuilder, wordIndex + 1, x + 1, y, flag);

            flag[x][y] = false;
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);

            return dfs || dfs1 || dfs2 || dfs3;
        } else {
            return false;
        }
    }
}
