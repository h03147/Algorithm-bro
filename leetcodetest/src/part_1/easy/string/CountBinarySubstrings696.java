package part_1.easy.string;

public class CountBinarySubstrings696 {

    public int countBinarySubstrings(String s) {

        /*
         * 分析题意：题目要求在一个二进制串s中找到相同数量的0和1的子串的个数，并且这些子串中所有0和1都是连续的
         * 后面出现和前面相同长度相同格式的重复子串也记一次次数。那么我们可以用双变量遍历s串完成统计，一个变量
         * preLen统计当前具有相同数量0或1的字符子串的前序相同规律的字符子串的个数，curLen统计当前具有相同数量
         * 0或1的字符子串个数，然后不停向后滑动，保证两个变量存储的是当前同数子串个数和前序同数子串个数。每统计
         * 完一个同数子串个数就去判断比较如果当前串长度还没有比前序串长度大，那就说明还能凑出一个子串就记一次次
         * 数，最后遍历完毕，返回count即可。
         */

        int preLen = 0, curLen = 1, count = 0;
        for(int i = 1; i < s.length(); ++i) {
            if(s.charAt(i) == s.charAt(i - 1)) {
                curLen++;
            } else {
                preLen = curLen;
                curLen = 1;
            }

            if(preLen >= curLen) {
                count++;
            }
        }
        return count;
    }

}
