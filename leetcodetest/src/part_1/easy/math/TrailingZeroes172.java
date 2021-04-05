package part_1.easy.math;

public class TrailingZeroes172 {

    public static void main(String[] args) {
        System.out.println(new TrailingZeroes172().trailingZeroes(50));
    }

    public int trailingZeroes(int n) {
        /*
         * 分析题意：题目要求找到数n阶乘尾数开始有多少个零，我们分析下多个连续的数相乘，哪几个数能乘出零呢？
         * 我们不难发现 2 * 5 能产生尾数是零的数，或者2和5的倍数相乘也可以产生，所以把2*5或者2*5的倍数作为一
         * 个组合存在，我们就是找能组成多少对组合的个数就是零的个数，在小于等于n的阶乘中，2的倍数的个数肯定比
         * 5的倍数的个数多，所以能组成的个数等于数量少的那个数的个数，故这里我们找5和其倍数的个数就是题目要的
         * n的阶乘零的数量了。
         */

        // // 递归的写法
        // return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);

        // 迭代的写法
        int count = 0;
        while(n / 5 != 0) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }

}
