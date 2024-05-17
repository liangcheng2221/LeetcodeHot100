package hot100.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author yinjie
 * @date 2024-04-28 8:21
 */
public class _78_子集 {
    // region 暴力 + 题解
    /**
     * 暴力枚举（这个也还没搞出来）
     *
     * @param nums 数组
     * @return 子集数组
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());

        if (nums.length == 0) {
            return list;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int k = i + 1; k < nums.length; k++) {
                List<Integer> arr = new ArrayList<>();
                arr.add(nums[k - 1]);
                list.add(new ArrayList<>(arr));
                for (int j = k; j < nums.length; j++) {
                    arr.add(nums[k]);
                    list.add(new ArrayList<>(arr));
                }
            }

        }

        return list;

    }

    /**
     * 回溯解法（题解版）
     * @param nums 数组
     * @return 子集列表
     */
    public List<List<Integer>> subsetsByHuiSu(int[] nums){
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());

        if (nums.length == 0) {
            return list;
        }
        return list;
    }
    //endregion

    // region 自己理解版
    public List<List<Integer>> subsetsByMy(int[] nums) {
        final List<List<Integer>> resultList = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        dfs(nums,resultList,0,deque);
        return resultList;
    }

    private void dfs(int[] nums, List<List<Integer>> resultList, int startIndex,Deque<Integer> deque) {
        resultList.add(new ArrayList<>(deque));
        for (int i = startIndex; i < nums.length; i++) {
            deque.push(nums[i]);
            dfs(nums,resultList,i + 1,deque);
            deque.pop();
        }
    }
    //endregion
}
