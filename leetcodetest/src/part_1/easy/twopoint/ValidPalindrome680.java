package part_1.easy.twopoint;

public class ValidPalindrome680 {

    public static void main(String[] args) {
        String s = "abca";
        System.out.println(validPalindrome(s));
    }

    public static boolean validPalindrome(String s) {

        /*
         * 分析题意：题目要求最多删除一个字符使其成为回文数，也就是说
         * 满足本题的true结果的情况有两种。
         * 情况一：不删除任何字符串s本身就是一个回文字符串，返回true
         * 情况二：仅删除s串中的任意一个字符后，s变成了一个回文字符串，返回true
         * 情况二继续细分：
         * 考虑到本题用到双指针来求解，首先low指针指向s的首字符，high指针指向s的尾字符
         * low从前向后遍历，high从后向前遍历，但碰到low位置对于字符和high位置对应字符
         * 不相等时，要么low位置删除当前位置元素，low指针加1，或者high位置删除当前位置
         * 元素，high指针减1。
         * 之后low继续正向遍历，high继续反向遍历，之后元素都满足题目条件，直到low等于
         * high结束返回true，否则返回false。
         */

        for(int low = 0, high = s.length() - 1; low < high; low++, high--) {
            if(s.charAt(low) != s.charAt(high)) {
                return isPalindrome(s, low + 1, high) || isPalindrome(s, low, high - 1);
            }
        }
        return true;
    }

    private static boolean isPalindrome(String s, int low, int high) {
        while(low < high) {
            // if(s.charAt(low) == s.charAt(high)) {
            //     low++;
            //     high--;
            // } else {
            //     return false;
            // }
            if(s.charAt(low++) != s.charAt(high--)) {
                return false;
            }
        }
        return true;
    }
}
