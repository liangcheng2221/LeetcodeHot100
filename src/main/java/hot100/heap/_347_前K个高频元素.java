package hot100.heap;

import java.util.*;

/**
 * @author yinjie
 * @date 2024-06-11 9:53
 */
public class _347_前K个高频元素 {

    /**
     * Hash存储解决 + 优先队列（小顶堆的思想） TODO 实现堆排序
     *
     * @param nums 数组
     * @param k    频数
     * @return 结果数组
     */
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // 哈希计数
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 创建优先队列
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        // 放进优先队列
        priorityQueue.addAll(entries);

        int[] result = new int[k];

        // 提取前面k个元素
        for (int i = 0; i < k; i++) {
            result[i] = priorityQueue.poll().getKey();
        }


        return result;
    }
}
