package part_1.medium.dp;

public class FindMaxForm474 {

    public static void main(String[] args) {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5, n = 3;
        System.out.println(new FindMaxForm474().findMaxForm(strs, m, n));
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for(String s : strs) {
            int zeros = 0, ones = 0;
            for(char c : s.toCharArray()) {
                if(c == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }

            for(int i = m; i >= zeros; --i) {
                for(int j = n; j >= ones; --j) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }

        return dp[m][n];
    }

}
