package part_1.easy.bitwiseoperator;

public class HasAlternatingBits693 {

    public boolean hasAlternatingBits(int n) {
        /*
         * 分析题意：如果 n 的二进制是 010101... 或者 101010... 交替出现的，我们可以尝试想到，相邻的两位数刚好异或
         * 我们不妨尝试让 n 右移一位，这样 1010 就变成 101了，然后 1010 ^ 101 正好就错位了，这两个数异或的结果为全1
         * 我们把这个异或的结果设为 a 存储起来，然后进一步验证下 a 是否是全1呢，于是我们进一步利用补1进位的特点，一个
         * 数二进制形式如果是全1，那么补一个1之后，最高位向左再进一个1，低为全部为0了，于是我们拿 a & (a + 1) 如果结
         * 果为0就验证成功。
         */
        int a = n ^ (n >> 1);
        return (a & (a + 1)) == 0;
    }

}