package part_1.easy.greedyalgorithm;

public class MaxSubArray53 {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        /*
         * 分析题意：题目要求找到连续子数组的最大和是多少
         * 那么我们首先要尝试去找到最大和子数组的起点，当
         * 然这个过程我们用肉眼看不出来，需要我们完整的遍
         * 历数组，找到所有可能连加和大于0的子数组，并不断
         * 的比较，最大的那个就是我们要找的最大和
         */

        // 初始化前驱子数组和位置
        int pre = nums[0];
        // 让最大连续子数组和初始化为前驱子数组和
        int max_subnums = pre;
        for(int i = 1; i < nums.length; ++i) {
            // 如果当前前驱子数组和大于0，那么我们当前位置nums[i]
            // 加前驱子数组和才有可能更大，否则重新定位前驱子
            // 数组和位置计算行的连续子数组和，在和之前已找到
            // 的连续子数组和比较，取最大的那个和为返回结果
            pre = pre > 0 ? pre + nums[i] : nums[i];
            max_subnums = Math.max(max_subnums, pre);
        }
        return max_subnums;
    }
}
