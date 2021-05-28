package part_1.easy.arrayandmatrix;

import java.util.HashMap;
import java.util.Map;

public class FindShortestSubArray697 {

    public int findShortestSubArray(int[] nums) {
        /*
         * 分析题意：题目大概意思就是要找出数组的众数，并且还要找出众数在数组中第一次出现和最后一次出现的位置，
         * 两个位置组成区间长度就是答案, 如果众数不止一个，那么要取区间长度最短那个。
         */
        Map<Integer, Integer> numCnt = new HashMap<>();
        Map<Integer, Integer> numFirstIndex = new HashMap<>();
        Map<Integer, Integer> numLastIndex = new HashMap<>();

        for(int i = 0; i < nums.length; ++i) {
            int num = nums[i];
            numCnt.put(num, numCnt.getOrDefault(num, 0) + 1);
            numLastIndex.put(num, i);
            if(!numFirstIndex.containsKey(num)) {
                numFirstIndex.put(num, i);
            }
        }
        int maxCnt = 0;
        for(int num : nums) {
            maxCnt = Math.max(maxCnt, numCnt.get(num));
        }
        int result = nums.length;
        for(int num : nums) {
            int cnt = numCnt.get(num);
            if(cnt != maxCnt) continue;
            result = Math.min(result, numLastIndex.get(num) - numFirstIndex.get(num) + 1);
        }
        return result;
    }

}
