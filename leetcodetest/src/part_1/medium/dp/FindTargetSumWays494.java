package part_1.medium.dp;

public class FindTargetSumWays494 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int S = 3;
        System.out.println(new FindTargetSumWays494().findTargetSumWays(nums, S));
    }

    public int findTargetSumWays(int[] nums, int S) {
        /*
         * 分析题意：01背包问题是选或者不选，但本题是必须选，是选+还是选-。先将本问题转换为01背包问题。
         * 可以将这组数看成两部分，P 和 N，其中 P 使用正号，N 使用负号，有以下推导：
         * 我们想要的 sum(P) - sum(N) = S 所有的正数和加上所有的负数和就是我们的目标和target
         * 而已知sum(N)与sum(P)的和是数组总和：sum(P) + sum(N) = sum
         * 将上述两个式子相加消元 sum(P) - sum(N) + sum(P) + sum(N) = S + sum
         * 可以求出 sum(P) = (S + sum) / 2 = target
         * 也就是我们要从nums数组里选出几个数，令其和为target
         * 于是就转化成了求容量为target的01背包问题 =>要装满容量为target的背包，有几种方案

         * 特例判断
         * 如果S大于sum，不可能实现，返回0
         * 如果sum(P)不是整数，也就是S + sum不是偶数，(S + sum) / 2 除不尽，有余数不可能实现等号条件，返回0

         * dp[j]代表的意义：填满容量为j的背包，有dp[j]种方法。因为填满容量为0的背包有且只有一种方法，所以dp[0] = 1
         * 状态转移：dp[j] = dp[j] + dp[j - num]，
         * 当前填满容量为j的包的方法数 = 之前填满容量为j的包的方法数 + 之前填满容量为j - num的包的方法数
         * 也就是当前数num的加入，可以把之前和为j - num的方法数加入进来。
         * 返回dp[-1]，也就是dp[target] 结束判断条件
         */

        int sum = generateArraySum(nums);

        // 如果数组中所有数的和都比target小或者按推导公式算出来的结果为非偶数即不能被2整除，那就找不到等号条件
        if(sum < S || (S + sum) % 2 == 1) {
            return 0;
        }

        int target = (S + sum) / 2;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int num : nums) {
            for(int j = target; j >= num; --j) {
                dp[j] = dp[j] + dp[j - num];
            }
        }

        return dp[target];

    }

    private int generateArraySum(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        return sum;
    }

}
