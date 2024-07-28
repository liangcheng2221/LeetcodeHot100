package hot100.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author <a href="https://github.com/liangcheng2221">yinjie</a>
 * @date 2024-04-16 8:01
 */
public class _200_岛屿数量 {
    /**
     * TODO 这题题目没看懂（一开始）
     *      看懂了，不过有点抽象
     *
     * @param grid
     * @return
     */
    // 深度优先
    public int count;

    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * 深度优先的做法
     *
     * @param grid 数组
     * @param i    row
     * @param j    col
     */
    private void dfs(char[][] grid, int i, int j) {
//        if (i == grid.length || grid[i].length == j){
//            return;
//        }
//        int row = grid.length;
//        int col = grid[i].length;
//        if (i == row - 1 && j == col - 1){
//            grid[i][j] = 0;
//            return;
//        }
//        if (i <= row - 1){
//            grid[i][j] = 0;
//            dfs(grid,i,++j);
//        }
//        if (j <= col - 1){
//            grid[i][j] = 0;
//            dfs(grid,++i,j);
//        }
        int row = grid.length;
        int col = grid[i].length;
        grid[i][j] = '0';
        if (i - 1 >= 0 && grid[i - 1][j] == '1') dfs(grid, i - 1, j);
        if (j - 1 >= 0 && grid[i][j - 1] == '1') dfs(grid, i, j - 1);
        if (i + 1 <= row - 1 && grid[i + 1][j] == '1') dfs(grid, i + 1, j);
        if (j + 1 <= col && grid[i][j + 1] == '1') dfs(grid, i, j + 1);
    }

    /**
     * 广度优先（有点抽象）
     * 跟着敲了一遍还是很好理解
     * 思路：二维遍历，如果有就直接入队进行广度优先搜索，存储的是二维转一维的索引
     * 然后直接上下左右进行判断，有就入队，直到队列为空才退出
     *
     * @param grid 数组
     */
    private int bfs(char[][] grid) {

        int count = 0;

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    grid[i][j] = '0';
                    Queue<Integer> queue = new LinkedList<>();
                    // 一维数组的索引的计算方法
                    queue.add(i * col + j);

                    while (!queue.isEmpty()) {
                        int id = queue.remove();
                        int row1 = id / col;
                        int col1 = id % col;
                        if (row1 - 1 >= 0 && grid[row1 - 1][col1] == '1') {
                            queue.add((row1 - 1) * col + col1);
                            grid[row1 - 1][col1] = '0';
                        }
                        if (row1 + 1 < row && grid[row1 + 1][col1] == '1') {
                            queue.add((row1 + 1) * col + col1);
                            grid[row1 + 1][col1] = '0';
                        }
                        if (col1 - 1 >= 0 && grid[row1][col1 - 1] == '1') {
                            queue.add(row1 * col + col1 - 1);
                            grid[row1][col1 - 1] = '0';
                        }
                        if (col1 + 1 < col && grid[row1][col1 + 1] == '1') {
                            queue.add(row1 * col + col1 + 1);
                            grid[row1][col1 + 1] = '0';
                        }
                    }
                }
            }

        }
        return count;
    }
}
