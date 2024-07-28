package hot100.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author <a href="https://github.com/liangcheng2221">yinjie</a>
 * @date 2024-05-06 11:06
 */
public class _39_组合总和 {
    /**
     * TODO 这里竟然自己做出来了，但是好像是带点运气
     *
     * @param candidates 数组
     * @param target     目标值
     * @return 返回组合的总和
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        dfs(resultList, deque, target, candidates, 0, 0);
        return resultList;
    }

    private void dfs(List<List<Integer>> resultList, Deque<Integer> deque, int target, int[] candidates, int count, int startIndex) {
        if (count == target) {
            resultList.add(new ArrayList<>(deque));
            return;
        }
        if (count > target) {
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            deque.push(candidates[i]);
            dfs(resultList, deque, target, candidates, count + candidates[i], i);
            deque.pop();
        }
    }
}
