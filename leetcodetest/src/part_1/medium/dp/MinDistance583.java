package part_1.medium.dp;

public class MinDistance583 {

    public static void main(String[] args) {
        String word1 = "sea", word2 = "eat";
        System.out.println(new MinDistance583().minDistance(word1, word2));
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        if(m == 0 || n == 0) return m + n;

        int[][] dp = new int[m + 1][n + 1];

        for(int i = 1; i <= m; ++i) {
            for(int j = 1; j <= n; ++j) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // 前序已经找到的最长公共子序列加1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 当前i和j位置字符不相等，说明错位了那就删除掉可能错位的位置(i或者j错位了二选一删掉一个)
                    // 回到i - 1，j或者i，j - 1前序最长公共子序列作为当前结果继续先后探寻
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        // word1串的长度加上word2串长度，减去他们相同的最长的公共子序列长度两倍剩下的就是要删除的字符所需的步长
        return m + n - 2 * dp[m][n];
    }

}
