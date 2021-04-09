package part_1.easy.math;

public class MaximumProduct628 {

    public static void main(String[] args) {
        System.out.println(new MaximumProduct628().maximumProduct(new int[] {1, 2, 3, 4}));
    }

    public int maximumProduct(int[] nums) {
        /*
         * 分析题意：
         * 方法1. 基于排序的方法
         * 1. 数组中的数全是正数，取最大的三个数相乘即可，数组中全是负数还是取最大的三个数相乘即可
         * 2. 数组中正数负数全都有，则最大值可能是最大的三个正数相乘，或者是最小的两个负数相乘再乘
         * 一个最大的正数
         * 综上：在排序后，最大值取三个最大正数或者是两个最小负数和一个最大正数相乘然后比较去最大值
         * 这两种情况就包揽了我们想要的全部解
         */
        // Arrays.sort(nums);
        // int n = nums.length;
        // return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 1] * nums[n - 2] * nums[n - 3]);

        /*
         * 方法2. 根据方法1.的总结可以知道最终的目的就是找到五个数，不需要排序的方法，也无论正负数直接一
         * 趟遍历根据排队传递性规则找出最大的三个数，外加两个最小的数即可。相当于我们拿五个指针，让大家开
         * 始排一列长队（无需按大小排序），三个指针动态的更新标记当前队列中的三个身高最高的人，两个指针动
         * 态的更新标记当前队列众两个身高最矮的同学，最后按照方法1的推到公式就能找到三个数的乘积最大值
         */
        // [min1, min2, ..., max3, max2, max1]
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for(int num : nums) {
            if(min1 > num) {
                min2 = min1;
                min1 = num;
            } else if(min2 > num) {
                min2 = num;
            }

            if(max1 < num) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if(max2 < num) {
                max3 = max2;
                max2 = num;
            } else if(max3 < num) {
                max3 = num;
            }
        }
        return Math.max(min1 * min2 * max1, max3 * max2 * max1);
    }

}
