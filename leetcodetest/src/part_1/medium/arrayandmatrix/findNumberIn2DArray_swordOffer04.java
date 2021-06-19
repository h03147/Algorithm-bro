package part_1.medium.arrayandmatrix;

public class findNumberIn2DArray_swordOffer04 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        /**
         * 分析题意：根据矩阵有序的特点，我们优先按列遍历，但是这一次我们优先遍历比较最后一列
         * 因为这样如果target比最后一列某一个数大直接让行指针跳到下一行最后一个数继续比较，
         * 不用再考虑当前行了。（相似的题可参考240题（我的刷题挑战第一百六十题有视频详解））
         */
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int r = 0, c = n - 1;
        while(r < m && c >= 0) {
            if(matrix[r][c] == target) {
                return true;
            } else if(matrix[r][c] < target) {
                r++;
            } else {
                c--;
            }
        }
        return false;
    }

}
