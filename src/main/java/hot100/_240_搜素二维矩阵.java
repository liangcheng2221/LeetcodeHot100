package hot100;

public class _240_搜素二维矩阵 {
    public boolean searchMatrix(int[][] matrix, int target) {


        for (int[] ints : matrix) {
            for (int anInt : ints) {
                if (anInt == target) {
                    return true;
                }
            }
        }

        return false;
    }
}
