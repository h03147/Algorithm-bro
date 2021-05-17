package part_1.easy.string;

public class CountSubstrings647 {

    private int cnt = 0;
    public int countSubstrings(String s) {
        /*
         * 分析题意：计算所有可能的子回文字符串，我们可以从头遍历字符串s，然后每一次都让双指针指向当前遍历的字符位置
         * 以它为中点位置恰好切割回文串两边，指针向两边移动，只要满足对称位置相等我们就记录一个子串为一个回文串。
         * 注意回文字符串有两种：
         * 情况一：回文串是奇数个长度，那中点就是一个，在正中间
         * 情况二：回文串是偶数个长度，那中点就是当前位置和当前位置的下一个位置相邻对半分回文串
         */
        for(int i = 0; i < s.length(); ++i) {
            extendSubStrings(s, i, i); // 回文串为奇数时的情况
            extendSubStrings(s, i, i + 1);// 回文串为偶数的情况
        }
        return cnt;
    }

    private void extendSubStrings(String s, int start, int end) {
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
            cnt++;
        }
    }

}
