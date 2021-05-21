package part_1.easy.arrayandmatrix;

public class MatrixReshape566 {

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;
        if(m * n != r * c) return mat;
        int[][] reshapeNUms = new int[r][c];
        // int index = 0;
        // for(int i = 0; i < r; ++i) {
        //     for(int j = 0; j < c; ++j) {
        //         reshapeNUms[i][j] = mat[index / n][index % n];
        //         index++;
        //     }
        // }
        for(int i = 0; i < m * n; ++i) {
            reshapeNUms[i / c][i % c] = mat[i / n][i % n];
        }
        return reshapeNUms;
    }

}
