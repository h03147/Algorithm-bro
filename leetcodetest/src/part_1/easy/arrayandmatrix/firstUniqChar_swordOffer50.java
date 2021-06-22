package part_1.easy.arrayandmatrix;

import java.util.BitSet;

public class firstUniqChar_swordOffer50 {

    public char firstUniqChar(String s) {
        // // 方法一 用128个空间的数组存，下标是小写字母，值存次数即可（字符的ASCII码最大不超过128）
        // int[] cnts = new int[128];
        // for(int i = 0; i < s.length(); ++i) {
        //     cnts[s.charAt(i)]++;
        // }
        // for(int i = 0; i < s.length(); ++i) {
        //     if(cnts[s.charAt(i)] == 1) {
        //         return s.charAt(i);
        //     }
        // }
        // return ' ';

        // 方法二 某个字符要么不出现，要么出现一次，要么出现两次，要么出现更多，起始我们只用记录出现一次或者两次
        // 两次以上都算更多，只用返回第一个只出现一次的即可 于是用位运算 看位数  00 表示0次 01 表示1次
        // 11 表示2次，返回 01 即是结果
        BitSet bs1 = new BitSet(128);
        BitSet bs2 = new BitSet(128);
        for(char c : s.toCharArray()) {
            if(!bs1.get(c) && !bs2.get(c)) {
                // 如果bs1中不存在c，bs2中也不存在c，代表第一次出现
                // bs1.get(int index) 方法返回的是boolean类型的表示索引处index的位值 是否有
                // bs1.set(int index) 表示第一次出现的c在bs1的索引位置c处把它设为true，代表已存一个
                bs1.set(c); // 00 -> 01
            } else if(bs1.get(c) && !bs2.get(c)) {
                // bs1中已经存在，但是bs2不存在证明出现了一次，现在是第二次出现
                // 于是存到bs2中对应索引位置，表示出现了两次
                bs2.set(c);
            } // else 就是更多次了，按本题意思，没有意义不用记录和不存在一并处理了
        }
        for(int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if(bs1.get(c) && !bs2.get(c)) {
                return c;
            }
        }
        return ' ';
    }

}
