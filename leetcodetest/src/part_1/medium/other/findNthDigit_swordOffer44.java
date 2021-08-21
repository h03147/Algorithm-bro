package part_1.medium.other;

public class findNthDigit_swordOffer44 {

    public int findNthDigit(int n) {
        int digit = 1; // 当前数字所属的位数：eg 10的位数是2，100的位数是3,1000的位数是4...
        long start = 1; // 当前digit位连续数字中的第一个数字 1位的第一个数是1, 2位的第一个数是10， 3位的第一个数是100，.....
        long count = 9; // 当前
        while (n > count) { // 1.确定所求数位的所在数字的位数
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.确定所求数位所在的数字
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.确定所求数位在 num 的哪一数位
    }

}
