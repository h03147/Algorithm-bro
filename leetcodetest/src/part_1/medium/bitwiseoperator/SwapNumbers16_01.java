package part_1.medium.bitwiseoperator;

// 面试题 16.01. 交换数字 (不用额外变量交换两个整数 程序员代码面试指南 ：P317)
public class SwapNumbers16_01 {

    public int[] swapNumbers(int[] numbers) {
        /*
         * 分析题意：不开辟额外空间，原地交换两个数，我们可以用到位运算的两个知识点
         * x ^ 0 = x, x ^ x = 0;
         * 例如第一个变量是a，第二个变量是b，那么我们先让 a = a ^ b，然后 b = a ^ b, 此时把前面 a 的新赋值带进来
         * 就得 b = a ^ b ^ b = a ^ 0 = a，这样 b = a 已经替换成功了，然后再让 a = a ^ b，把前面两个式子带入第
         * 三个式子中得：a = a ^ b ^ a ^ b ^ b，偶数个异或为0，0异或任何数都为任何数，得到结果 a = b。替换完毕。
         */
        numbers[0] = numbers[0] ^ numbers[1];
        numbers[1] = numbers[0] ^ numbers[1];
        numbers[0] = numbers[0] ^ numbers[1];
        return numbers;
    }

}
