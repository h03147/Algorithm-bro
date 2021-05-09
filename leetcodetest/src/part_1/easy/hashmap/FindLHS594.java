package part_1.easy.hashmap;

import java.util.HashMap;
import java.util.Map;

public class FindLHS594 {

    public int findLHS(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        // 先统计每个元素出现的次数
        for(int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        int longest = 0;
        // 类似于滑动窗口如果存在相邻的两个数（必定最大值和最小值差值为1），并且加起来的个数和最大就覆盖掉最大值
        for(int num : hashMap.keySet()) {
            if(hashMap.containsKey(num +1)) {
                longest = Math.max(longest, hashMap.get(num) + hashMap.get(num + 1));
            }
        }
        return longest;
    }

}
