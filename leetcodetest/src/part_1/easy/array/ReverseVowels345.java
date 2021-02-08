package part_1.easy.array;

import java.util.Arrays;
import java.util.HashSet;

public class ReverseVowels345 {

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(reverseVowels(s));
    }

    private final static HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public static String reverseVowels(String s) {

        // HashSet<Character> hashSet = new HashSet<>();
        // char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        // for(char vowel : vowels) {
        //     hashSet.add(vowel);
        // }
        int low = 0, high = s.length() - 1;
        // 结果数组开辟空间
        char[] answers = new char[s.length()];
        while(low <= high) {
            char char_i = s.charAt(low);
            char char_j = s.charAt(high);
            if(!vowels.contains(char_i)) {
                answers[low++] = char_i;
            } else if(!vowels.contains(char_j)) {
                answers[high--] = char_j;
            } else {
                // 找到了当前这一对需要对调位置的元音字母对
                answers[low++] = char_j;
                answers[high--] = char_i;
            }
        }
        return new String(answers);

    }
}
