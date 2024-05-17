package hot100;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _73_矩阵置零 {
    /**
     * 思路：思路不难，就遍历记录零的行和列即可（用到的数据结构是Set）,然后根据列行置零即可
     * @param matrix
     */
    public static void setZeroes(int[][] matrix) {
        Set<Integer> setCol = new HashSet<>();
        Set<Integer> setRow = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0){
                    setCol.add(j);
                    setRow.add(i);
                }
            }
        }

        for (Integer i : setRow) {
            Arrays.fill(matrix[i], 0);
        }
        for (Integer j : setCol) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][j] = 0;
            }
        }

    }

    public static void main(String[] args) {
        int[][] ints = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes(ints);
        System.out.println(Arrays.deepToString(ints));
    }
}
