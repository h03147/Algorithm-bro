package part_1.medium.bitwiseoperator;

public class MaxProduct318 {

    public int maxProduct(String[] words) {
        /**
         * 分析题意：字符串数组的字符串只含有小写字符。求解字符串数组中两个字符串长度的最大乘积，要求这两个字符串
         * 不能含有相同字符。本题主要问题是判断两个字符串是否含相同字符，由于字符串只含有小写字符，总共 26 位，
         * 因此可以用一个 32 位的整数来存储每个字符是否出现过。
         */


        int n = words.length;
        int[] val = new int[n];
        for(int i = 0; i < n; ++i) {
            for(char c : words[i].toCharArray()) {
                val[i] |= 1 << (c - 'a');
            }
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((val[i] & val[j]) == 0) {
                    ret = Math.max(ret, words[i].length() * words[j].length());
                }
            }
        }
        return ret;
    }

}
