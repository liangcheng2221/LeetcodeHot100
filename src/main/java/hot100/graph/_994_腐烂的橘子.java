package hot100.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author yinjie
 * @date 2024-04-17 9:14
 */
public class _994_腐烂的橘子 {

    /**
     * 广度优先
     * 思路：首先遍历所有坏掉的橘子，放进队列，然后遍历队列，
     * 用一个map对象存储每个节点的分钟数，最后一个节点的map值就是最后的分钟数，直到没有新鲜橘子
     * 和岛屿数量还是不太一样
     *
     * @param grid
     * @return
     */
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    int code = i * col + j;
                    queue.add(code);
                    map.put(code, 0);
                }
            }
        }

        int ans = 0;
        while (!queue.isEmpty()) {
            int code = queue.remove();
            int row1 = code / row;
            int col1 = code % col;
            if (row1 - 1 >= 0 && grid[row1 - 1][col1] == 1) {
                grid[row1 - 1][col1] = 2;
                int ncode = (row1 - 1) * col + col1;
                queue.add(ncode);
                map.put(ncode, map.get(code) + 1);
                ans = map.get(ncode);
            }
            if (row1 + 1 < row && grid[row1 + 1][col1] == 1) {
                grid[row1 + 1][col1] = 2;
                int ncode = (row1 + 1) * col + col1;
                queue.add(ncode);
                map.put(ncode, map.get(code) + 1);
                ans = map.get(ncode);
            }
            if (col1 - 1 >= 0 && grid[row1][col1 - 1] == 1) {
                grid[row1][col1 - 1] = 2;
                int ncode = row1 * col + col1 - 1;
                queue.add(ncode);
                map.put(ncode, map.get(code) + 1);
                ans = map.get(ncode);
            }
            if (col1 + 1 < col && grid[row1][col1 + 1] == 1) {
                grid[row1][col1 + 1] = 2;
                int ncode = row1 * col + col1 + 1;
                queue.add(ncode);
                map.put(ncode, map.get(code) + 1);
                ans = map.get(ncode);
            }

        }

        for (int[] ints : grid) {
            for (int k : ints) {
                if (k == 1) {
                    return -1;
                }
            }
        }
        return ans;
    }
}