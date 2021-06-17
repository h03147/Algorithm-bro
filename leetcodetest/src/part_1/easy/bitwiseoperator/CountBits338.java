package part_1.easy.bitwiseoperator;

public class CountBits338 {

    public int[] countBits(int n) {
        // // 方法一 调用工具类 遍历统计每个数二进制数对应一的个数即可
        // int[] ret = new int[n + 1];
        // for(int i = 1; i <= n; ++i) {
        //     ret[i] = Integer.bitCount(i);
        // }
        // return ret;

        // 方法二 动态规划 找到递推方程为 dp[i] = dp[i&(i-1)] + 1
        // 验证：6（110） = 4(100) + 2(10)
        // 根据n & (n - 1) 实际上是把 n 的二进制数中最低为的1给去掉了，这里6的二进制110相当于把第二位1给去掉了
        // 而4的二进制100刚好等于2的二进制10 + 1 得到的，故推出动态规划递推式 dp[i] = dp[i&(i-1)] + 1
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; ++i) {
            dp[i] = dp[i & (i - 1)] + 1;
        }
        return dp;
    }

}
