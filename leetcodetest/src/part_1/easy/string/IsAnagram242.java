package part_1.easy.string;

public class IsAnagram242 {

    public boolean isAnagram(String s, String t) {
        /*
         * 分析题意：本题并不需要保证相对位置上的稳定顺序，只要保证每个小写字符出现的类型和对应的次数刚好相匹配
         * 就返回true，否则就返回false，所以两个字符串完全相等只是其中一种特例，更多的情况下是异位的单词。
         * 故这里提供两种解题思路:
         * 方法一：最容易想到的就是用hashmap统计第一个字符串中各个字符出现的次数，然后遍历第二个字符串去hashmap
         * 找存在就把次数减一抵消，最后如果hashmap为空了就返回true否则false。
         * 方法二：用一个数组的存储空间开辟26个空间存储（题目规定只有小写英文字母）第一个字符串出现的次数，下标索
         * 引是对应单词字符，值存其出现的次数。第二趟遍历第二个字符串t去数组中找到对应次数减一抵消，再遍历一遍数组，
         * 判断子只要有一个位置上值不为0就说明匹配不成功返回false，否则返回true。
         */

        // 方法一
        // Map<Character, Integer> map = new HashMap<>();
        // for(char c : s.toCharArray()) {
        //     map.put(c, map.getOrDefault(c, 0) + 1);
        // }
        // for(char c : t.toCharArray()) {
        //     Integer count = map.get(c);
        //     if(count == null) {
        //         return false;
        //     } else if(count > 1) {
        //         map.put(c, count - 1);
        //     } else {
        //         map.remove(c);
        //     }
        // }
        // return map.isEmpty();

        // 方法二
        int[] cnts = new int[26];
        for(char ch : s.toCharArray()) {
            cnts[ch - 'a']++;
        }
        for(char ch : t.toCharArray()) {
            cnts[ch - 'a']--;
        }
        for(int i = 0; i < cnts.length; ++i) {
            if(cnts[i] != 0) {
                return false;
            }
        }
        return true;
    }

}
