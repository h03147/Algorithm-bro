package part_1.easy.arrayandmatrix;

public class spiralOrder_swordOffer29 {
    public int[] spiralOrder(int[][] matrix) {
        /**
         * 分析题意：一层一层从外到里打印，观察可知每一层打印都有相同的处理步骤，唯一不同的是
         * 上下左右的边界不同了。因此使用四个变量 r1, r2, c1, c2 分别存储上下左右边界值，从而
         * 定义当前最外层。打印当前最外层的顺序：从左到右打印最上一行->从上到下打印最右一行->
         * 从右到左打印最下一行->从下到上打印最左一行。应当注意只有在 r1 != r2 时才打印最下一行，
         * 也就是在当前最外层的行数大于 1 时才打印最下一行，这是因为当前最外层只有一行时，继续打印
         * 最下一行，会导致重复打印。打印最左一行也要做同样处理。
         */
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length, columns = matrix[0].length;
        int r1 = 0, r2 = matrix.length - 1;
        int c1 = 0, c2 = matrix[0].length - 1;
        int[] ret = new int[rows * columns];
        int index = 0;
        while(r1 <= r2 && c1 <= c2) {
            for(int i = c1; i <= c2; ++i) {
                ret[index++] = matrix[r1][i]; // 从左向右，打印最上面
            }
            for(int i = r1 + 1; i <= r2; ++i) {
                ret[index++] = matrix[i][c2]; // 从上向下，打印最右边
            }
            if(r1 != r2) {
                for(int i = c2 - 1; i >= c1; --i) {
                    ret[index++] = matrix[r2][i]; // 从右向左，打印最下边
                }
            }
            if(c1 != c2) {
                for(int i = r2 - 1; i > r1; --i) {
                    ret[index++] = matrix[i][c1]; // 从下向上，打印最左边
                }
            }
            r1++; c2--; r2--; c1++;
        }
        return ret;
    }
}
