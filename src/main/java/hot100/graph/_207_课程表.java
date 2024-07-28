package hot100.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="https://github.com/liangcheng2221">yinjie</a>
 * @date 2024-04-24 9:11
 */
public class _207_课程表 {

    List<List<Integer>> edge;
    int[] visited;
    boolean valid = true;

    /**
     * 广度优先和深度优先都能做（TODO）
     * 深度优先（有点算是理解）
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        edge = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            // 初始化二维链表
            edge.add(new ArrayList<>());
        }
        // 记录每个节点的状态 ，0 代表没搜索 ， 1 代表搜索中 ，2 代表搜索完成
        visited = new int[numCourses];

        // 绑定出度节点
        for (int[] info : prerequisites) {
            edge.get(info[1]).add(info[0]);
        }

        // 深度遍历每个节点
        for (int i = 0; i < numCourses && valid; i++) {
            // 为零代表没被搜索
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    /**
     * 沿着没有前驱节点的节点进行深度优先搜索
     *
     * @param i
     */
    private void dfs(int i) {
        visited[i] = 1;
        for (int j : edge.get(i)) {
            if (visited[j] == 0) {
                dfs(j);
                if (!valid) {
                    return;
                }
            } else if (visited[j] == 1) {
                valid = false;
                return;
            }
        }
        visited[i] = 2;
    }
}
