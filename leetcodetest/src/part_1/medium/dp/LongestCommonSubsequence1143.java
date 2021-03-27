package part_1.medium.dp;

public class LongestCommonSubsequence1143 {

    public static void main(String[] args) {
        System.out.println(new LongestCommonSubsequence1143().longestCommonSubsequence("abcdfe", "ace"));
    }

    public int longestCommonSubsequence(String text1, String text2) {

        /*
         * 分析题意:如果text1的第i个字符(text1[i - 1])和text2的第j个字符(text2[j - 1])相等
         * 则有dp[i][j] = dp[i - 1][j - 1] + 1，也就是在text1的前
         * i - 1个字符和text2的前j - 1个字符的最长公共子序列长度dp[i - 1][j - 1]上再加1
         * 如果text1的第i个字符(text1[i - 1])和text2的第j个字符(text2[j - 1])不相等，那就要
         * 看text1的前i个字符和text2的前j - 1个字符，以及text1的前i - 1个字符和text2的前j个
         * 字符的最长公共子序列长度哪个大了，因为当前i和j对应的字符无法匹配，只能从前面的情况转
         * 移而来，dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
         */

        int m1 = text1.length(), n1 = text2.length();
        // dp[i][j]含义：text1的前i个字符[0, i)和text2的前j个字符[0, j)的最长公共子序列的长度
        int[][] dp = new int[m1 + 1][n1 + 1];
        for(int i = 1; i <= m1; ++i) {
            for(int j = 1; j <= n1; ++j) {
                if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m1][n1];

    }

}
