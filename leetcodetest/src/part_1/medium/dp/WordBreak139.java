package part_1.medium.dp;

import java.util.ArrayList;
import java.util.List;

public class WordBreak139 {

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(new WordBreak139().wordBreak(s, wordDict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        // 背包时s字符串，物品时wordDict中的每一个word，向背包里面装物品，并且强调顺序性
        for(int i = 1; i <= n; ++i) {
            for(String word : wordDict) {
                int len = word.length();
                if(len <= i && word.equals(s.substring(i - len, i))) {
                    // 要么转包，要么不装包
                    dp[i] = dp[i] || dp[i - len];
                }
            }
        }
        return dp[n];
    }

}
