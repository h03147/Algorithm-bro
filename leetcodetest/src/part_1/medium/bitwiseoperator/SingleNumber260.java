package part_1.medium.bitwiseoperator;

public class SingleNumber260 {

    public int[] singleNumber(int[] nums) {
        /*
         * 分析题意：之前我们做的题目是找出一组数组中只出现一次的那个数，直接连续异或遍历一遍重复出现两次的数异或为0
         * 最后剩下的那一个数就是结果，那本题中数组中只出现一次的数有两个，我们用同样的方法异或求得的是着两个只出现一
         * 次的数异或的结果，并非这两个数，我们需要的是通过这个结果把这两个数的找出来，那怎么办呢？
         * 大胆试想一下，我还是想要用异或的方法，有没有一种方法能把整个数组拆分成两个子数组，让两个只出现一次的数分别
         * 出现在一个子数组中，这样我们再去异或两个子数组不就有变成一个数组中只有一个数出现一次的问题了。
         * 我们想一想之前将位运算第一题时我们学过这个知识点：
         * n&(-n) 得到 n 的位级表示中最低的那一位 1。
         * 这样我们把数组遍历一遍异或的结果就是只出现一次的那两个数异或的结果，单从二进制数的位上面去看，本质上是保留了
         * 这两个数相异个位置上的数标记为1了。因为两个数不相同所以按异或结果的二进制数最右边不为0的那个数1就是这两个数
         * 中其中一个数那一位是这个数了，通过这个特性，我们继续分析：
         *
         */
        int diff = 0;
        for(int num : nums) {
            diff = diff ^ num;
        }

        diff &= -diff;
        int[] result = new int[2];
        for(int num : nums) {
            if((num & diff) == 0) result[0] ^= num;
            else result[1] ^= num;
        }
        return result;

    }

}
