package hot100;

import java.util.ArrayList;
import java.util.List;

public class _54_螺旋矩阵 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int[] ints = new int[]{0, 0};
        List<Integer> list = new ArrayList<>();
        int count = matrix.length * matrix[0].length - 1;

        // 记录行走还是列走
        boolean flag = true;

        while (count >= 0) {

            if (flag) {
                for (int i = 0; i < matrix[ints[0]][i]; i++) {
                    // 行扫描，列扫描时-1
                    list.add(matrix[ints[0]][i]);
                    ints[1]++;
                    flag = false;
                }
            }

        }


        return null;
    }

    public static void main(String[] args) {

    }
}
