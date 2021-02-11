package part_1.medium.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FrequencySort451 {

    public static void main(String[] args) {
        String s = "tree";
        System.out.println(frequencySort(s));
    }

    public static String frequencySort(String s) {
        // 创建一个hashmap把字符串中的每一个字符次数遍历出来
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int size = s.length();

        for(int i = 0; i < size; ++i) {
            hashMap.put(s.charAt(i), hashMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        // 为桶排序的桶开辟空间
        List<Character>[] buckets = new ArrayList[size + 1];

        for(char key : hashMap.keySet()) {
            int value_count = hashMap.get(key);
            if(buckets[value_count] == null) {
                buckets[value_count] = new ArrayList<>();
            }
            buckets[value_count].add(key);
        }

        // 为结果集开辟空间
        char[] result = new char[size];

        // 按频次由高到低输出字符串
        int i =0, k;
        for(k = size; k > 0; --k) {
            if(buckets[k] != null) {
                for(char c : buckets[k]) {
                    for(int j = 0; j < k; ++j) {
                        result[i++] = c;
                    }
                }
            }
        }
        return new String(result);
    }
}
