package part_1.medium.dp;

public class IntegerBreak343 {


    public static void main(String[] args) {
        System.out.println(new IntegerBreak343().integerBreak(10));
    }

    public int integerBreak(int n) {
        // 这里取值范围取 n + 1 是为了方便下标取值，下标从零开始，但是dp[0] = 0，我们不需要，我们需要取到dp[n]
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for(int i = 2; i <= n; ++i) {
            for(int j = 1; j < i; ++j) {
                // 要么就拆分为 j 和 i - j 两个数的乘积，要么继续拆分 i - j 为其他至少两个数的乘积，然后比较取乘积最大的
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }

        return dp[n];
    }

}
