package part_1.medium.dp;

import java.util.*;

public class dicesSum_swordOffer60 {

    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        final int face = 6;
        final int pointNum = face * n;
        long[][] dp = new long[n + 1][pointNum + 1];
        for(int i = 1; i <= face; ++i) {
            dp[1][i] = 1;
        }

        for(int i = 2; i <= n; ++i) {
            // i 个骰子最小点数和为i个1
            for(int j = i; j <= pointNum; ++j) {
                for(int k = 1; k <= face && k <= j ; ++k) {
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }
        final double totalNum = Math.pow(6, n);
        List<Map.Entry<Integer, Double>> ret = new ArrayList<>();
        for(int i = n; i <= pointNum; ++i) {
            ret.add(new AbstractMap.SimpleEntry<>(i, dp[n][i] / totalNum));
        }
        return ret;
    }
}
