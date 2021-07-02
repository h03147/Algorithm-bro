package part_1.easy.twopoint;

public class reverseLeftWords_swordOffer58 {

    public String reverseLeftWords(String s, int n) {
        /**
         * 分析题意：本题涉及到翻转字符串，可以考虑用双指针，先把s字符串转换成字符数组，然后以n为数组下标
         * 分界线，（0， n - 1）为前半截，(n, size - 1)为后半截。先把两段分别翻转，然后整体翻转一下，
         * 就是我们要的结果。
         * 例如：
         * Input:
         * s="abcXYZdef"
         * n=3
         *
         * 先将 "abc" 和 "XYZdef" 分别翻转，得到 "cbafedZYX"，然后再把整个字符串翻转得到 "XYZdefabc"。
         */
        int size = s.length();
        char[] chars = s.toCharArray();
        if(n >= size) {
            return s;
        }
        reverse(chars, 0, n - 1);
        reverse(chars, n, size - 1);
        reverse(chars, 0, size - 1);
        return new String(chars);
    }

    private void reverse(char[] chars, int i, int j) {
        while(i < j) {
            swap(chars, i++, j--);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;
    }

}
