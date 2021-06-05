package part_1.easy.bitwiseoperator;

public class HammingDistance461 {

    public int hammingDistance(int x, int y) {
        /*
         * 分析题意：让 x 和 y 做异或运算即可知道相异的是哪几位，然后统计异或后1的个数就是两个整数之间的汉明距离
         */

        // // 方法一 调用统计二进制数中1个数的工具类
        // return Integer.bitCount(x ^ y);

        //  // 方法二 异或 x，y 再与上1 + 右位移运算，统计1的位数
        // int z = x ^ y;
        // int cnt = 0;
        // while(z != 0) {
        //     if((z & 1) == 1) cnt++;
        //     z = z >> 1;
        // }
        // return cnt;

        // 方法三 n&(n-1) 去除 n 的位级表示中最低的那一位 1
        int z = x ^ y;
        int cnt = 0;
        while(z != 0) {
            z &= z - 1;
            cnt++;
        }
        return cnt;
    }

}
