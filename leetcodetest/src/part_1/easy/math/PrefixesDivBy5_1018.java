package part_1.easy.math;

import java.util.ArrayList;
import java.util.List;

/**
 * description: 1018 可被 5 整除的二进制前缀 位运算 + 数学分析
 */
public class PrefixesDivBy5_1018 {

    public static void main(String[] args) {
        int[] A = {1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1};
        System.out.println(prefixesDivBy5(A));
    }

    public static List<Boolean> prefixesDivBy5(int[] A) {
        /**
         * 思路，能被5整除的十进制数，任意一个数减去个位数的值后都是一个整数，整数都能被5整除
         * 所以本题十位数以上一定能被5整除不用考虑，只用考虑到每次得到的十进制数的个位能否被5
         * 整除即可
         **/
        int size = A.length;
        int sum = 0;
        List<Boolean> result_list = new ArrayList<Boolean>();
        // // 1.可读性高 方便理解版
        // for(int i = 0; i < size; ++i) {
        //     sum <<= 1; // 每次上一个数做位运算左移一位变成下一个数的十位数
        //     sum += A[i]; // 下一个数等于上一个十进制数加上当前最后一位二进制
        //                 // (最后一位二进制数无论是0或者1都和换算成十进制数值都一样所以可以直接加)
        //     sum %= 10; // 取个位数
        //     result_list.add(sum % 5 == 0);
        // }

        // 2.减少代码冗余版 根据数论中同余运算规则 sum %= 10 等价于 sum %= 5
        for(int item : A) {
            result_list.add( ( sum = ((sum << 1) + item) % 5 ) == 0);
        }

        return result_list;

    }
}
