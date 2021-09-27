package part_1.medium.math;

public class Divide29 {

    public int divide(int dividend, int divisor) {
        // // 辗转相减法
        // /**
        // * 因为将 -2147483648 转成正数会越界，但是将 2147483647 转成负数，则不会
        // * 所以，我们将 dividend 和 divisor 都转成负数时间复杂度：O(n)，
        // * n 是最大值 2147483647 --> 10^10 --> 超时
        // * 32 位最大值：2^31 - 1 = 2147483647
        // * 32 位最小值：-2^31 = -2147483648
        // * -2147483648 / (-1) = 2147483648 > 2147483647 越界了
        //  */

        //  // 边界处理
        // if(dividend == Integer.MIN_VALUE && divisor == -1) {
        //     return Integer.MAX_VALUE;
        // }
        // // 记录符号，然后统一转化成负数处理，防止溢出
        // int sign = (dividend > 0) ^ (divisor > 0) ? -1 : 1;
        // if(dividend > 0) dividend = -dividend;
        // if(divisor > 0) divisor = -divisor;
        // int res = 0;
        // while(dividend <= divisor) {
        //     dividend -= divisor;
        //     res++;
        // }
        // // 结果把符号位加上
        // return sign == -1 ? -res : res;

        // 辗转相减法 优化后
        if(dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int sign = (dividend > 0) ^ (divisor > 0) ? -1 : 1;
        if(dividend > 0) dividend = -dividend;
        if(divisor > 0) divisor = -divisor;
        int res = 0;
        while(dividend <= divisor) {
            int value = divisor;
            int k = 1;
            // 0xc0000000 是十进制 -2^30 的十六进制的表示
            // 判断 value >= 0xc0000000 的原因：保证 value + value 不会溢出
            // 可以这样判断的原因是：0xc0000000 是最小值 -2^31 的一半，
            // 而 a 的值不可能比 -2^31 还要小，所以 value 不可能比 0xc0000000 小
            // -2^31 / 2 = -2^30
            while(value >= 0xc0000000 && dividend <= value + value) {
                value += value;
                k += k;
            }
            dividend -= value;
            res += k;
        }
        return sign == -1 ? -res : res;
    }

}
