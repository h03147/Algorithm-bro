package part_1.medium.dp;

import java.util.Arrays;

public class FindLongestChain646 {

    public static void main(String[] args) {
        int[][] pairs = {{1, 2}, {2, 3}, {3, 4}};
        System.out.println(new FindLongestChain646().findLongestChain(pairs));
    }

    public int findLongestChain(int[][] pairs) {
        /*
         * 分析题意：找不相交子序列最长链的问题，分析点就在找到满足题意条件的左右边界上，问题就能得以解决
         */
        // 把当前数列对按升序排列
        Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));
        int n = pairs.length;
        int[] dp = new int[n];
        // 初始情况下，最少肯定有一对，我们就把dp全部填充为左边界的最小值1
        Arrays.fill(dp, 1);

        for(int i = 1; i < n; ++i) {
            for(int j = 0; j < i; ++j) {
                // 如果前序数对的右边界小于当前数对的左边界，那么可以扩容
                if(pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // return Arrays.stream(dp).max().orElse(0);

        int result = 0;
        for(int i = 0; i < n; ++i) {
            result = Math.max(result, dp[i]);
        }
        return result;

    }

}
