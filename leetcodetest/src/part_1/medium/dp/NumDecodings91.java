package part_1.medium.dp;

public class NumDecodings91 {

    public static void main(String[] args) {
        System.out.println(new NumDecodings91().numDecodings("12"));
    }

    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n]; // 存储当前数字时的解码种数
        dp[0] = 1; // 没有实际意义，只是一种情况
        if(s.charAt(0) == '0') {
            return 0;
        }
        for(int i = 1; i < n; ++i) {
            if(s.charAt(i) == '0') {
                // 出现0，但是0前面不是1，2，不能解码
                if(s.charAt(i - 1) != '1' && s.charAt(i - 1) != '2') return 0;
                // 0出现在位置1，只有一种解码方式，出现在其他位置等于dp[i - 2]
                dp[i] = i == 1 ? 1 : dp[i - 2];
            } else if(s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) - '0' > 0 && s.charAt(i) - '0' < 7)) {
                // 出现两种解法方式的条件
                // 出现在位置1，没有i - 2
                // 出现在其他位置dp[i - 1]+ dp[i - 2]
                dp[i] = i == 1 ? dp[i - 1] + 1 : dp[i - 1] + dp[i - 2];
            } else {
                // 只有一种解码
                dp[i] = dp[i - 1];
            }
        }
        return dp[n - 1];
    }

}
