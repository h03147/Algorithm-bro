package part_1.medium.sort;

import java.util.ArrayList;
import java.util.List;

public class FindLongestWord524 {

    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> d = new ArrayList<>();
        d.add("ale");
        d.add("apple");
        d.add("monkey");
        d.add("plea");
        System.out.println(findLongestWord(s, d));
    }

    public static String findLongestWord(String s, List<String> d) {
        // 为最长单词字符串开辟一个空间
        String longestWord = "";
        // 去遍历字符串字典d，判断里面的每一个字符串是否为s的子串
        for(String d_target : d) {
            int len1 = longestWord.length(), len2 = d_target.length();
            // 下一次循环前先做结果判断，如果已经找到的最长子串
            // 比下一个要遍历的子串长或者和即将遍历的子串一样长
            // 字典顺序更小，那么这次循环就没有必要，直接跳出这次循环就行了
            if(len1 > len2 || (len1 == len2 && longestWord.compareTo(d_target) < 0)) {
                continue;
            }
            // 判断当前d_target是否是新的最长子串
            if(isSubString(s, d_target)) {
                longestWord = d_target;
            }
        }
        return longestWord;
    }

    private static boolean isSubString(String s, String d_target) {
        // 用双指针去遍历两个串找子串
        int p1 = 0, p2 = 0;
        while(p1 < s.length() && p2 < d_target.length()) {
            if(s.charAt(p1) == d_target.charAt(p2)) {
                p2++;
            }
            p1++;
        }
        // if(p2 == d_target.length()) {
        //     return true;
        // } else {
        //     return false;
        // }
        return p2 == d_target.length();
    }
}
