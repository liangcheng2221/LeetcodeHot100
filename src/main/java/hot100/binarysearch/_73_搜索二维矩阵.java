package hot100.binarysearch;

/**
 * @author yinjie
 * @date 2024-05-16 8:59
 */
public class _73_搜索二维矩阵 {
    /**
     * TODO 二重二分查找比半循环半二分查找效率略低
     *
     * @param matrix 二维数组
     * @param target 目标值
     * @return 是否存在目标值
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int col = matrix[0].length;
        int firstRow = searchMatrixFirstRow(matrix, target);

        if (firstRow == -1) {
            return false;
        }
        System.out.println(firstRow);

        // 右边一定要能索引
        int right = col - 1;
        int left = 0;

        while (right >= left) {
            int index = (left + right) / 2;
            if (matrix[firstRow][index] == target) {
                return true;
            }
            if (matrix[firstRow][index] < target) {
                left = index + 1;
            } else if (matrix[firstRow][index] > target) {
                right = index - 1;
            }
        }
        return false;
    }

    /**
     * 查找目标值所在的行
     *
     * @param matrix 二维数组
     * @param target 目标值
     * @return 返回的索引值
     */
    private int searchMatrixFirstRow(int[][] matrix, int target) {
        int right = matrix.length - 1;
        int left = 0;
        int index;
        while (left <= right) {
            index = (left + right) / 2;
            if (target == matrix[index][0]) {
                return left;
            }
            if (target < matrix[index][0]) {
                right = index - 1;
            } else {
                left = index + 1;
            }
        }

        return left;

    }

}
