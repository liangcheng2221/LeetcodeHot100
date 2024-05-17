package hot100;

public class _48_旋转图像 {
    public void rotate(int[][] matrix) {

        int count = 0;

        while (count < Math.floorDiv(matrix.length, 2)){
            int temp = matrix[0][0];
            matrix[0][0] = matrix[matrix.length - 1][0];
            matrix[matrix.length - 1][0] = matrix[matrix.length - 1][matrix.length - 1];
            matrix[matrix.length - 1][matrix.length - 1] = temp;
        }

    }
}
