package part_1.easy.dp;

import java.util.ArrayList;
import java.util.List;

public class NumArray303 {


    private int[] sums;


    public static void main(String[] args) {
        NumArray303 numArray303 = new NumArray303();
        int[] nums = {-2, 0, 3, -5, 2, -1};
        numArray303.NumArray(nums);
        List<Integer> result = new ArrayList<>();
        result.add(null);
        result.add(numArray303.sumRange(0, 2));
        result.add(numArray303.sumRange(2, 5));
        result.add(numArray303.sumRange(0, 5));

        System.out.println(result);
    }

    public void NumArray(int[] nums) {
        /*
         * 分析题意：本题要计算从索引i到索引j范围内元素的总和，可以转换为两个累加和做差，
         * 即累加和sum[j + 1]和累加和sum[i]做差。
         */
        int n = nums.length;
        // 数组下标从0开始，我们开辟n + 1个空间是为了方便sunRange的运算i为0不需要做特殊处理了
        sums = new int[n + 1];
        for(int i = 0; i < n; ++i) {
            // sum[i + 1]计算的是0到i下标的累加和
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        // 这里 right +　1 减去 left 是计算0到right的累加和减去0到left - 1的累加和，
        // 剩下的刚好就是left到right的闭区间总和了
        return sums[right + 1] - sums[left];
    }

}
