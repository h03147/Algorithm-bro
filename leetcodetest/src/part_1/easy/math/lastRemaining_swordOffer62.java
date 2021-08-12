package part_1.easy.math;

public class lastRemaining_swordOffer62 {

    public int lastRemaining(int n, int m) {
        /**
         * 分析题意：约瑟夫环，圆圈长度为 n 的解可以看成长度为 n-1 的解再加上报数的长度 m。
         * 因为是圆圈，所以最后需要对 n 取余。
         */
        if(n == 1) return 0;
        return (lastRemaining(n - 1, m) + m) % n;
    }

}
