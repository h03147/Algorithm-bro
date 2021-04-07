package part_1.easy.math;

import javax.imageio.stream.ImageInputStream;

public class IsPerfectSquare367 {

    public static void main(String[] args) {
        System.out.println(new IsPerfectSquare367().isPerfectSquare(16));
    }

    public boolean isPerfectSquare(int num) {

        /*
         * 分析题意：本题有一个规律是我们之前做过的刷题挑战的第六十二题(leecode 279 题)中就做过了
         * 找到小于等于n的所有完全平方数，你会发现一个规律，从最小的1开始连续增加的完全平方数
         * 1，4，9，16，25...他们之间的间隔刚好是一个以1为初始值，差为2的等差数列，4 - 1 = 3，
         * 9 - 4 = 5，16 - 9 = 7...，1，3，5，7，9，11...这样一个等差数列，那么按照这个规律，
         * 我们从num开始做减等差数列的操作，如果是完全平方数最后一定能减到0，反之则不行.
         */
        int sum = 1;
        while(num > 0) {
            num -= sum;
            sum += 2;
        }
        return num == 0;
    }
}
