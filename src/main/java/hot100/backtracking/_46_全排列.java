package hot100.backtracking;

import java.util.*;

/**
 * @author <a href="https://github.com/liangcheng2221">yinjie</a>
 * @date 2024-04-25 10:13
 */
public class _46_全排列 {

    // region 题解版

    /**
     * 这个是真的不是很好理解（题解版）
     *
     * @param nums 数组
     * @return 返回全排列
     */
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();

        ArrayList<Integer> output = new ArrayList<>();

        for (int num : nums) {
            output.add(num);
        }

        int len = nums.length;

        backtrack(len, output, res, 0);
        return res;
    }

    private void backtrack(int len, ArrayList<Integer> output, List<List<Integer>> res, int startIndex) {
        if (startIndex == len) {
            res.add(new ArrayList<>(output));
        }

        for (int i = startIndex; i < len; i++) {
            // 动态维护数组
            Collections.swap(output, startIndex, i);

            // 继续递归
            backtrack(len, output, res, startIndex + 1);

            // 撤销操作
            Collections.swap(output, startIndex, i);
        }

    }
    // endregion

    //  region 视频版
    /**
     * 视频版（就和深度优先的区别：多了一个回退过程）
     *
     * @param nums 数组长度
     * @return 返回全排列列表
     */
    public List<List<Integer>> permuteByVideo(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> output = new ArrayDeque<>();
        boolean[] booleans = new boolean[nums.length];
        dfs(nums, res, output, booleans, 0);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, Deque<Integer> output, boolean[] booleans, int depth) {
        int length = nums.length;
        if (depth == length) {
            res.add(new ArrayList<>(output));
            return;
        }

        for (int i = 0; i < length; i++) {
            if (booleans[i]) {
                booleans[i] = false;
                output.addLast(nums[i]);
                dfs(nums, res, output, booleans, depth + 1);
                booleans[i] = true;
                output.removeLast();
            }
        }

    }
    // endregion

    // region 自己理解版

    public List<List<Integer>> permuteByMy(int[] nums) {
        final List<List<Integer>> resultList = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] booleans = new boolean[nums.length];
        dfsByMy(nums,stack,booleans,resultList);
        return resultList;
    }

    private void dfsByMy(int[] nums, Deque<Integer> stack,boolean[] booleans,List<List<Integer>> resultList) {
        if (nums.length == stack.size()){
            resultList.add(new ArrayList<>(stack));
        }
        for (int i = 0  ; i < nums.length; i++) {
            if (!booleans[i]){
                stack.push(nums[i]);
                booleans[i] = true;
                dfsByMy(nums,stack,booleans,resultList);
                booleans[i] = false;
                stack.pop();
            }
        }
    }


    //endregion
}
