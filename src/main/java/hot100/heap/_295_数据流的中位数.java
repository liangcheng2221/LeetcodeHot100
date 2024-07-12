package hot100.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yinjie
 * @date 2024-06-11 9:55
 */
public class _295_数据流的中位数 {
    private final List<Integer> list = new ArrayList<>();

    public _295_数据流的中位数() {

    }

    public void addNum(int num) {
        list.add(num);
    }

    public double findMedian() {
        int size = list.size();


        return size % 2 == 0 ? (double) (list.get(size / 2) +  list.get(size / 2 - 1)) / 2 : list.get(size / 2);
    }
}
