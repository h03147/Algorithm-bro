package part_1.easy.arrayandmatrix;

public class IsToeplitzMatrix766 {

    public boolean isToeplitzMatrix(int[][] matrix) {
        // 检验第一行
        for(int i = 0; i < matrix[0].length; ++i) {
            if(!check(matrix, matrix[0][i], 0, i)) {
                return false;
            }
        }
        // 检验第一列
        for(int j = 1; j < matrix.length; ++j) {
            if(!check(matrix, matrix[j][0], j, 0)) {
                return false;
            }
        }
        return true;
    }
    private boolean check(int[][] matrix, int expectValue, int row, int col) {
        if(row >= matrix.length || col >= matrix[0].length) {
            return true;
        }
        if(matrix[row][col] != expectValue) {
            return false;
        }
        return check(matrix, expectValue, row + 1, col + 1);
    }

}
