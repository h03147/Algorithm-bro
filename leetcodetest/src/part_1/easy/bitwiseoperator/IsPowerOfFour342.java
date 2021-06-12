package part_1.easy.bitwiseoperator;

public class IsPowerOfFour342 {

    public boolean isPowerOfFour(int n) {
        // 这种数在二进制表示中有且只有一个奇数位为 1，例如 16（10000）。
        return n > 0 && (n & (n - 1)) == 0 && (n & 0b01010101010101010101010101010101) != 0;
    }

}
