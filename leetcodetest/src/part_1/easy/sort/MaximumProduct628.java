package part_1.easy.sort;

/**
 * description: 628 三个数的最大乘积
 */
public class MaximumProduct628 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(maximumProduct(nums));
    }

    public static int maximumProduct(int[] nums) {
        /*
        分析情况：
        方法1. 基于排序的方法
        1. 数组中的数全是正数，取最大的三个数相乘即可，数组中全是负数取还是取最大的三个数相乘即可
        2. 数组中整数负数全都有，则最大值可能是三个最大正数相乘，或者是两个最小负数相乘再乘一个最
           大正数
        综上：在排序后，最大值取三个最大整数或者是两个最小负数和一个最大整数相乘这两种情况就包揽了
        全部的解
        */
        // Arrays.sort(nums);
        // int n = nums.length;
        // return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 3] * nums[n - 2] * nums[n - 1]);

        /*
        方法2. 根据方法1.的总结可以知道最终的目的就是找到五个数，不需要排序的方法，也无论正负数直接一
        趟遍历根据排队传递性规则找出最大的三个数，外加两个最小的数即可
        */
        // 首先找出最小的两个数,min1最小，min2第二小
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        // 再就是最大的第二大和第三大的三个数(max1, max2, max3)
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;

        for(int item : nums) {
            if(item < min1) {
                min2 = min1;
                min1 = item;
            } else if (item < min2) {
                min2 = item;
            }

            if(item > max1) {
                max3 = max2;
                max2 = max1;
                max1 = item;
            } else if(item > max2) {
                max3 = max2;
                max2 = item;
            } else if(item > max3) {
                max3 = item;
            }
        }

        return Math.max(min1 * min2 * max1, max3 * max2 * max1);
    }
}
