package part_1.medium.dp;

public class MinSteps650 {

    public static void main(String[] args) {
        System.out.println(new MinSteps650().minSteps(3));
    }

    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 0; // 初始化的时候就有一个A,不用做任何操作
        int h = (int) Math.sqrt(n);
        for(int i = 2; i <= n; ++i) {
            dp[i] = i;
            for(int j = 2; j <= h; ++j) {
                if(i % j == 0) {
                    dp[i] = dp[j] + dp[i / j];
                    break;
                }
            }
        }

        return dp[n];
    }

}
