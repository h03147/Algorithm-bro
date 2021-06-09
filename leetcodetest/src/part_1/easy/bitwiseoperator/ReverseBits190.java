package part_1.easy.bitwiseoperator;

import java.util.*;

public class ReverseBits190 {

    // you need treat n as an unsigned value

    // 方法二的缓存参数，用hashmap来模拟
    private static Map<Byte, Integer> cache = new HashMap<>();

    public int reverseBits(int n) {
        // // 方法一 二进制形式逐位颠倒
        // /*
        // * 将 n 视作一个长为 32 的二进制串，从低位往高位枚举 n 的每一位，将其倒序添加到翻转结果 ret 中。代码实现中，
        // * 每枚举一位就将 n 右移一位，这样当前 n 的最低位就是我们要枚举的比特位。当 n 为 0 时即可结束循环。
        // * 注意 java 中没有无符号整数类型，因此对 n 的右移操作应使用逻辑右移。
        //  */

        // int ret = 0;
        // // n 最多位32位，我们就循环颠倒32次，当 n 不足 32位时，我们碰到了0右移还是零不影响结果。
        // for(int i = 0; i < 32; ++i) {
        //     // ret作为结果，我们每次取新的n中最低位颠倒过来给ret的低位时，原来已经颠倒的位需要向左再进一位，保证相对
        //     // 左右顺序不变的情况下，空出最右边的一个低位来给新的有效位，这样先取的数就能保证在更左边，符合颠倒逻辑
        //     ret <<= 1;

        //     // n & 1 就是把当前 n 中最低位有效位给取出来，再把与出来的结果和 ret 做或操作，也就是在保留原先ret中已经
        //     // 存在的有效位1并且这些1已经在上一步左移过一位了，保证最低为空出来给我们当前从n中取的最低位，作为ret中的
        //     // 次高位。
        //     ret |= (n & 1);
        //     // n中低位已经成功取出来颠倒给ret做高位的位可以废弃掉了，java中直接做无符号逻辑右移就能抛弃掉二进制数中
        //     // 最低位的数
        //     n >>>= 1;
        // }
        // return ret;

        // 方法二 多次调用的优化
        // 如果该函数需要被调用很多次，可以将 int 拆成 4 个 byte，然后缓存 byte 对应的比特位翻转，最后再拼接起来
        // 这样多次调用如果有重复的就优先调用缓存返回结果，而不是去计算
        // 1 byte = 8 bit 八位 0b11111111，4 byte 就是 32 bit，即32位

        int ret = 0;
        for(int i = 0; i < 4; ++i) {
            // 8位一存
            ret <<= 8;
            ret |= reverseByte((byte) (n & 0b11111111));
            // 右移 1 Byte
            n >>= 8;
        }
        return ret;
    }

    // 方法二的缓存封装方法
    private int reverseByte(byte b) {
        if(cache.containsKey(b)) return cache.get(b);
        int ret = 0;
        // t当作中间变量，要参与运算并且要做位运算覆盖，b一会还有用所以不能覆盖参与运算
        byte t = b;
        for(int i = 0; i < 8; ++i) {
            ret <<= 1;
            ret |= (t & 1);
            t >>= 1;
        }
        // 新计算出来的ret和当前这个 byte 建立缓存关系
        cache.put(b, ret);
        return ret;
    }

}
