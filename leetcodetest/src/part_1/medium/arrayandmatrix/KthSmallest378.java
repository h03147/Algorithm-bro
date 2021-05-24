package part_1.medium.arrayandmatrix;

public class KthSmallest378 {

    public int kthSmallest(int[][] matrix, int k) {
        /*
         * 分析题意：题目要求在有序数组中找到第k小的元素，也就是按从小到大排序顺序，找到第k个元素输出即可，
         * 最简单的方法就是把矩阵遍历一遍降维放到一维数组中去，然后排序一维数组，输出第k - 1个位置上的数即
         * 可，这是暴力求排序求解法，我们不做展开，本题我们要用二分法来降低时间复杂度，于是我们可以这样，每
         * 次折中找到一个mid值，然后遍历一遍数组找到所有不大于mid值的元素个数我们这里设为cnt，相当于把矩阵
         * 切割成两半，然后比较不大于mid元素的个数cnt和k的大小，如果cnt < k 说明第k小元素在大于mid的右半部
         * 分这时让低位指针的 mid + 1，否则说明k已经覆盖到不大于mid的左半部分里去了，我们就让 high = mid - 1
         * 向左折半缩小范围即可，最后可以在O(nlogk), k = high - low 的时间复杂度内找到答案。
         */
        int m = matrix.length, n = matrix[0].length;
        int low = matrix[0][0], high = matrix[m - 1][n - 1];
        while(low <= high) {
            int mid = low + (high - low) / 2;
            int cnt = 0;
            for(int i = 0; i < m; ++i) {
                for(int j = 0; j < n && matrix[i][j] <= mid; ++j) {
                    cnt++;
                }
            }
            if(cnt < k) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }

}
