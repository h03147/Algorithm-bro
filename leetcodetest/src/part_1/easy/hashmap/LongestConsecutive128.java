package part_1.easy.hashmap;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutive128 {

    public int longestConsecutive(int[] nums) {
        /*
         * 分析题意：本题需要在无序的数组中找到最长连续序列，其中一种做法就是先排序，然后双指针统计暴力求解，这里我们
         * 不展开去讲，而是用到我们正在学习的知识点哈希表去实现，遍历一遍数组，key存值，value初始化存出现的次数都是1
         * 存入countForNum这个哈希表，然后再遍历一遍nums数组，dfs每一个以num开始，向后在countForNum中存在连续的
         * num + 1，最长有多长，把长度存到num对应的value中。全部连续子序列长度找完后，最后再遍历一遍countForNum,
         * 找到最大的value就是最长连续序列。
         */
        Map<Integer, Integer> countForNum = new HashMap<>();
        for(int num : nums) {
            countForNum.put(num, 1);
        }
        for(int num : nums) {
            forward(countForNum, num);
        }
        return maxCount(countForNum);
    }

    private int forward(Map<Integer, Integer> countForNum, int num) {
        // 递归后下一个连续的num + 1不存在，马上收敛返回
        if(!countForNum.containsKey(num)) {
            return 0;
        }
        // 获取当前num出现的次数
        int cnt = countForNum.get(num);
        // 非第一次出现了，已经统计过了直接收敛返回，无需重复操作
        if(cnt > 1) {
            return cnt;
        }
        // 从num开始一直向后递归判断是否存在相邻的key，一直dfs到最后一个连续的key然后每次收敛返回一层都加一个key
        // 收敛到最初的num后就是该num开始的最长序列长度
        cnt = forward(countForNum, num + 1) + 1;
        // 更新它的value为从其开始的最长序列个数
        countForNum.put(num, cnt);
        return cnt;
    }

    private int maxCount(Map<Integer, Integer> countForNum) {
        int max = 0;
        // 找到当前哈希表中最长的序列长度
        for(int num : countForNum.keySet()) {
            max = Math.max(max, countForNum.get(num));
        }
        return max;
    }

}
