package part_1.easy.hashmap;

import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {

    public int[] twoSum(int[] nums, int target) {
        /*
         * 分析题意: 两数之和这题常规思路是先把数组排序，然后用双指针或者二分法求解，时间复杂度为O(nlogn),
         * 空间复杂度为O(1)，那这里我们正在学哈希表，不妨尝试下用空间换时间来做这个题目，我们把数组中所有的
         * 值依次作为hashmap的key，而数组下标index存储为key对应的value，这样我们一趟遍历，把所有数组值和
         * 索引的键值对插入到hashmap中，每插入一个num:index，我们就做一个判断是否存在一个key为
         * target - nums[i]，如果存在则说明正好（i对应位置的数）+ （target - nums[i]）这两个数的和就是
         * target了，返回索引i和target - nums[i]作为key对应的value即为答案。
         * 时间复杂度为O(n),空间复杂度为O(n),典型的用空间换时间。
         */
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; ++i) {
            if(map.containsKey(target - nums[i])) {
                return new int[] {i, map.get(target - nums[i])};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

}
