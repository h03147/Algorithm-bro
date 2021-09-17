package part_1.easy.array;

public class LongestCommonPrefix14 {

    public String longestCommonPrefix(String[] strs) {
        // 按位纵向比较第一个strs[0]和其他每一个strs[i]的那一位是否相等，只要碰到一个字符串中的当前位字符
        // 不匹配或者i已经到其中某个字符串结尾了，都说明匹配结束了，已经是最长的前缀匹配了。反之说明最长的
        // 前缀就是strs[0]
        if(strs == null || strs.length == 0) {
            return "";
        }
        int n = strs[0].length();
        int cnt = strs.length;
        for(int i = 0; i < n; ++i) {
            char c = strs[0].charAt(i);
            for(int j = 1; j < cnt; ++j) {
                if(i == strs[j].length() || c != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

}
