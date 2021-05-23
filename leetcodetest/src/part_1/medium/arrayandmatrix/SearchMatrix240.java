package part_1.medium.arrayandmatrix;

public class SearchMatrix240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        // 方法一 比较第一列再从第一个不小于target的行开始从左向右遍历
        // int r = matrix.length, c = matrix[0].length;
        // for(int i = 0; i < r; ++i) {
        //     if(target < matrix[i][0]) {
        //         return false;
        //     } else if(target == matrix[i][0]) {
        //         return true;
        //     } else {
        //         for(int j = 1; j < c; ++j) {
        //             if(target == matrix[i][j]) {
        //                 return true;
        //             }
        //         }
        //     }
        // }
        // return false;

        // 方法二 在方法一基础上优化，根据矩阵有序的特点，我们优先按列遍历，但是这一次我们优先遍历比较最后一列
        // 因为这样如果target比最后一列某一个数大直接让行指针跳到下一行最后一个数继续比较，不用再考虑当前行了。
        int m = matrix.length, n = matrix[0].length;
        int r = 0, c = n - 1;
        while(r < m && c >= 0) {
            if(target == matrix[r][c]) {
                return true;
            } else if(target < matrix[r][c]) {
                c--;
            } else {
                r++;
            }
        }
        return false;
    }

}
