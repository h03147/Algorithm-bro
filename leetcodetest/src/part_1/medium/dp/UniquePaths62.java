package part_1.medium.dp;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class UniquePaths62 {

    public static void main(String[] args) {
        System.out.println(new UniquePaths62().uniquePaths(3, 7));
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // 第一列算是一种方法
        for(int i = 0; i < m; ++i) {
            dp[i][0] = 1;
        }
        // 第一行也算是一种方法
        for(int j = 0; j < n; ++j) {
            dp[0][j] = 1;
        }
        // 然后剩下来的行和列每一个路径从上向下走是一种方法，从左向右走也是一种方法所以要累加起来
        for(int i = 1; i < m; ++i) {
            for(int j = 1; j < n; ++j) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

}
