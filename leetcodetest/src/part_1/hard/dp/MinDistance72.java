package part_1.hard.dp;

public class MinDistance72 {

    public static void main(String[] args) {
        String word1 = "horse", word2 = "ros";
        System.out.println(new MinDistance72().minDistance(word1, word2));
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();

        if(m == 0 && n == 0) return 0;
        if(m * n == 0) return m + n;

        int[][] dp = new int[m + 1][n + 1];

        // 第一列 也就是当word2为空的时候，word1变成word2在做删除操作，直到删除干净了
        for(int i = 1; i <= m; ++i) {
            dp[i][0] = dp[i - 1][0] + 1;
        }

        // 第一行 也就是当word1为空的时候要变成word2操作，一直在做插入操作变成word2
        for(int j = 1; j <= n; ++j) {
            dp[0][j] = dp[0][j - 1] + 1;
        }

        // word1和word2都不为0的时候，我们就有两种可能的操作
        // 当word[i] = word[j]时，dp[i][j] = dp[i - 1][j - 1] 也就是不用做任何操作就匹配了直接继承前序即可
        // 当word[i] != word[j]时，
        // dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1
        // 也就是可以进行三种操作，三者取操作数最小的那个就行
        // dp[i - 1][j - 1] + 1 替换操作
        // dp[i - 1][j] + 1 删除操作
        // dp[i][j - 1] + 1 插入操作
        for(int i = 1; i <= m; ++i) {
            for(int j = 1; j <= n; ++j) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }

        return dp[m][n];
    }

}
