package part_1.medium.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations17 {

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if(digits == null || digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        // 回溯
        BackTracking(combinations, phoneMap, 0, digits, new StringBuilder());
        return combinations;
    }

    private static void BackTracking(List<String> combinations, Map<Character, String> phoneMap, int index,
                              String digits, StringBuilder combination) {
        if(index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char c = digits.charAt(index);
            String letters = phoneMap.get(c);
            int lettersCount = letters.length();;
            for(int i = 0; i < lettersCount; ++i) {
                combination.append(letters.charAt(i));
                BackTracking(combinations, phoneMap, index + 1, digits, combination);
                combination.deleteCharAt(index);
            }
        }
    }
}
