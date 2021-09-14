package part_1.medium.string;

public class IntToRoman12 {

    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    public String intToRoman(int num) {

        /**
         * 分析题意：根据罗马数字的唯一表示法，为了表示一个给定的整数 num，我们寻找不超过 num 的最大符号值，
         * 将num 减去该符号值，然后继续寻找不超过 num 的最大符号值，将该符号拼接在上一个找到的符号之后，循环
         * 直至 num 为 0。最后得到的字符串即为 num 的罗马数字表示。
         * 编程时，可以建立一个数值-符号对的列表 valueSymbols，按数值从大到小排列。遍历 valueSymbols 中的
         * 每个数值-符号对，若当前数值 value 不超过 num，则从 num 中不断减去 value，直至 num 小于 value，
         * 然后遍历下一个数值-符号对。若遍历中 num 为 0 则跳出循环。
         */

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < values.length; ++i) {
            while(num >= values[i]) {
                num -= values[i];
                sb.append(symbols[i]);
            }
            if(num == 0)  {
                break;
            }
        }
        return sb.toString();
    }

}
