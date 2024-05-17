package hot100.backtracking;

import java.util.*;

/**
 * @author yinjie
 * @date 2024-05-09 9:48
 */
public class _51_N皇后 {
    /**
     * TODO 这个也是真的抽象
     *
     * @param n 二维数组的长度
     * @return 返回满足条件的二维数组
     */
    /*
        算是有点理解了：
        递归解释条件就是递归的深度为数组的长度
        循环每次从零开始（不符合条件直接继续循环），这里可以直接用二维数组来代表每一行的数据（不需要单独写一个一维数组）
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        boolean[][] booleans = new boolean[n][n];
        List<String> list = new ArrayList<>();
        dfs(result, n, booleans, list, 0);
        return result;
    }

    private void dfs(List<List<String>> result, int n, boolean[][] booleans, List<String> list, int depth) {
        if (depth == n) {
            result.add(new ArrayList<>(list));
        }

        for (int i = 0; i < n; i++) {
            if (!isValid(i, n, depth, booleans)) {
                continue;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < n; j++) {
                stringBuilder.append(".");
            }
            String string = stringBuilder.toString();
            char[] charArray = string.toCharArray();
            charArray[i] = 'Q';
            booleans[depth][i] = true;
            list.add(new String(charArray));
            System.out.println(new String(charArray));
            dfs(result, n, booleans, list, depth + 1);
            booleans[depth][i] = false;
            list.remove(list.size() - 1);
        }
    }

    private boolean isValid(int col, int n, int row, boolean[][] booleans) {
        // 检查列
        for (int i = 0; i < row; i++) { // 这是一个剪枝
            if (booleans[i][col]) {
                return false;
            }
        }
        // 检查 45度角是否有皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (booleans[i][j]) {
                return false;
            }
        }
        // 检查 135度角是否有皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (booleans[i][j]) {
                return false;
            }
        }
        return true;
    }


//    public static void main(String[] args) {
//        System.out.println(isValid(2, 3,1,new boolean[][]{
//                {false, false, false},
//                {false, false, false},
//                {false, true, false},
//        }));
//    }
}
