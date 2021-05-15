package part_1.easy.string;

public class LongestPalindrome409 {

    public int longestPalindrome(String s) {
        /*
         * 分析题意：题目要求找出最长回文串个数，不要求相对位置按s串顺序，我们分析回文串特点，
         * 有两种情况：
         * 情况一：所有字符出现个数都是偶数次，那整个s串就能拼成一个对称的回文串
         * 情况二：字符串中出现了奇数个数字符，那么我们的最长回文串长度只能是s串中所有偶数个
         * 串长度加上任意一个奇数个字符作为回文串的正中心把偶数个串左右分割对称
         */

        // // 方法一 查ASCII表，用一个数组下标桶排序，下标是字符对应的ASCII值，数组值存的是每个字符出现的次数
        // int[] cnts = new int[123];
        // for(char ch : s.toCharArray()) {
        //     cnts[ch]++;
        // }
        // int palindrome = 0;
        // for(int cnt : cnts) {
        //     palindrome += cnt / 2 * 2;
        // }
        // if(palindrome < s.length()) {
        //     palindrome++;
        // }
        // return palindrome;

        // // 方法一优化 缩小空间复杂度，只要大小写字母个数个存储空间,外加一些中间的无用的字符进一步缩小空间
        // int[] cnts = new int[58];
        // for(char ch : s.toCharArray()) {
        //     cnts[ch - 'A']++;
        // }
        // int palindrome = 0;
        // for(int cnt : cnts) {
        //     palindrome += cnt / 2 * 2;
        // }
        // return palindrome < s.length() ? palindrome + 1 : palindrome;

        // 方法三 逆向思维，统计所有字符出现次数，把奇数个全部减去，剩下的就是偶数个，再加1即可
        int[] cnts = new int[58];
        for(char ch : s.toCharArray()) {
            cnts[ch - 'A']++;
        }
        int noPalindrome = 0;
        for(int cnt : cnts) {
            if(cnt % 2 == 1) {
                noPalindrome++;
            }
        }
        return noPalindrome == 0 ? s.length() : (s.length() - noPalindrome + 1);

    }

}
