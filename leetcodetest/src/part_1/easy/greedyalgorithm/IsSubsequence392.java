package part_1.easy.greedyalgorithm;

public class IsSubsequence392 {

    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }

    public static boolean isSubsequence(String s, String t) {
        // 方法一 双指针遍历
        // int len1 = s.length(), len2 = t.length();
        // int i = 0, j = 0;
        // while(i < len1 && j < len2) {
        //     if(s.charAt(i) == t.charAt(j)) {
        //         i++;
        //     }
        //     j++;
        // }
        // return i == len1;

        // 方法二 indexOf
        int index = -1;
        for(char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if(index == -1) {
                return false;
            }
        }
        return true;
    }
}
