package hot100;

import java.util.Arrays;

public class _56_合并区间 {
    /**
     * 直接暴力，好像不能实现要求，TODO 用排序的思想，但是有点不太好理解
     *
     * @param intervals
     * @return
     */
    public static int[][] merge(int[][] intervals) {


        int[][] ints = new int[intervals.length][2];
        int k = 0;
        for (int i = 0; i < intervals.length - 1; i++) {

            if (i == intervals.length - 2 && intervals[i - 2][1] < intervals[i - 1][0]) {
                ints[k][0] = intervals[i][0];
                ints[k][1] = intervals[i][1];
                k++;
                ints[k][0] = intervals[i + 1][0];
                ints[k][1] = intervals[i + 1][1];
                break;
            }

            if (intervals[i][1] >= intervals[i + 1][0] && intervals[i][0] >= intervals[i + 1][0]) {
                ints[k][0] = intervals[i + 1][0];
                ints[k][1] = intervals[i + 1][1];
                intervals[i][0] = intervals[i + 1][0];
                intervals[i][1] = intervals[i + 1][1];
                i++;
                k++;
            } else if (intervals[i][1] >= intervals[i + 1][0] && intervals[i][0] < intervals[i + 1][0]) {
                ints[k][0] = intervals[i][0];
                ints[k][1] = intervals[i + 1][1];
                intervals[i][0] = intervals[i][0];
                intervals[i][1] = intervals[i + 1][1];
                i++;
                k++;
            } else {
                ints[k][0] = intervals[i][0];
                ints[k][1] = intervals[i][1];
                k++;
            }
        }


        k = 0;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i][0] == 0 && ints[i][1] == 0) {
                break;
            }
            k++;
        }

        int[][] result = new int[k][2];

        for (int i = 0; i < k; i++) {
            result[i][0] = ints[i][0];
            result[i][1] = ints[i][1];
        }

        return result;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
    }
}
