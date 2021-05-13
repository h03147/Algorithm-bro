package part_1.easy.string;

import java.util.Arrays;

public class ReverseWords150 {

    public static void main(String[] args) {
        /**
         * 题目来源于程序员面试指南：翻转单词顺序
         * 描述：输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
         * eg： 输入 "I am a student" ，输出 "student a am I"。
         */
        String s = "   I       am     a     student   ";

        // 方法一 借助数组拆分反向遍历
//        String[] str2Arr = s.split(" ");
//        System.out.println(Arrays.toString(str2Arr));
//        int n = str2Arr.length;
//        StringBuilder sb = new StringBuilder();
//        for(int i = n - 1; i >= 0; --i) {
//            if(str2Arr[i].equals("")) continue;
//            sb.append(str2Arr[i] + " ");
//        }
//        System.out.print(sb.toString().trim());
////        System.out.print("*");

        // 方法二 双指针法
        s.trim(); // 先把首尾空格删掉
        int j = s.length() - 1, i = j;
        StringBuilder sb = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') i--; // 一直遍历到一个完整单词结束也就是碰到第一个空格为止
            sb.append(s.substring(i + 1, j + 1) + " ");
            while(i >= 0 && s.charAt(i) == ' ') i--; // 跳过中间多余的空格
            j = i;
        }
        System.out.print(sb.toString().trim());
//        System.out.print("*");


    }

}
