package part_1.easy.math;

public class IsPowerOfThree326 {

    public static void main(String[] args) {
        System.out.println(new IsPowerOfThree326().isPowerOfThree(27));
    }

    public boolean isPowerOfThree(int n) {
        // // 方法一 3的幂，结合我们前面学习的进制转换本题是不是可以联想到三进制数的转换
        // if(n < 1) {
        //     return false;
        // }

        // // 如果n可以拆分为x个3，那每一趟除以3的余数一定为0
        // while(n % 3 == 0) {
        //     // 辗转相除法，逢三进一位，让中间结果不断减小
        //     n /= 3;
        // }
        // // 如果是3的幂次除到最后肯定是 3 / 3 = 1，否则就返回false
        // return n == 1;

        // 方法二 整数限制，整型数最大范围有限制，我们通过找Integer.MAX_VALUE，得知最大的数能取到的
        // 3的幂次为 3^19 = 1162261467，而3又是质数，根据数学性质，3^19的除数包括了3^0 到 3^19，故
        // 只要n大于0并且 1162261467 % n == 0, 说明这个n一定在除数范围内，是3的幂数。
        return n > 0 && (1162261467 % n == 0);
    }

}
