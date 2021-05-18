package part_1.easy.string;

public class IsPalindrome9 {

    public boolean isPalindrome(int x) {
        /*
         * 分析题意：题目要求我们不能转换成字符串比对，也就是说不能开辟额外的空间，那这个时候我们就只能把整型数字
         * 对半拆分，然后倒置右半部分的数字，最后判断右半部分和左半部分数是否值相等就行了。
         * 在拆分的过程中同样需要考虑回文数的两种情况
         * 当回文数为偶数个长度时，左半部分等于右半部分倒置，返回true
         * 当回文数为奇数个长度时，此时while循环结束右半部分长度比左半部分多了正中间的那一位，也就是说把右半部分再
         * 除以10去掉最后一个位数，然后比较值相等返回true即可
         */
        if(x == 0) {
            return true;
        }
        if(x < 0 || x % 10 == 0) {
            return false;
        }
        int right = 0;
        while(x > right) {
            right = right * 10 + x % 10;
            x /= 10;
        }
        return x == right || x == right / 10;
    }

}
