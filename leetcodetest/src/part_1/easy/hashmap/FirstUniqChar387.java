package part_1.easy.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * description: 387 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 */
public class FirstUniqChar387 {

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(finds2c(s));
    }

    private static int finds2c(String s) {
        char[] s2c = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for(char item : s2c)
        {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        for(int i =0; i < s2c.length; ++i)
        {
            if(map.get(s2c[i]) == 1)
            {
                return i;
            }
        }
        return -1;
    }
}
