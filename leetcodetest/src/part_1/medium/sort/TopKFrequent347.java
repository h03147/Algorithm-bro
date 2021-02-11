package part_1.medium.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TopKFrequent347 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println();
        List<Integer> result = new ArrayList<>();
        for(int num : topKFrequent(nums, 2)) {
            result.add(num);
        }
        System.out.print(result);
    }

    public static int[] topKFrequent(int[] nums, int k) {
        /*
         * 分析题意：出现频次前k高的元素，尝试下用桶排序的知识来求解，
         * 我们把数出现的频次作为每个桶的标签，然后把出现相同频次的数
         * 字放入到对应的桶当中，而桶的标签范围是根据数可能出现的最大
         * 次数决定的，接着初始化的时候标签就已经是按从小到大的顺序排
         * 好无需我们再次比较排序，直接倒过来从标签最大的桶反向遍历每
         * 个桶，从倒数第一个不为空的桶开始算，把里面的数取出来，就是
         * 频次出现最高的k个数了。
         */
        // 定义一个hashmap来初始化每个数出现的频次，key是数值，value是频次
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        // 返回的结果集开辟空间
        int[] result = new int[k];

        for(int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] list = new ArrayList[nums.length + 1];
        // 让数字key出现的频次value作为桶的索引index
        for(int num : hashMap.keySet()) {
            int i = hashMap.get(num);
            // 如果当前桶当中还未建立对应的桶表我们就初始化一个
            if(list[i] == null) {
                list[i] = new ArrayList<>();
            }
            list[i].add(num);
        }
        int i = 0, t, j;
        // 从频次最高的第一个不为空的桶开始反向取值
        for(t = nums.length; t > 0; --t) {
            if(list[t] != null) {
                for(j = 0; j < list[t].size() && i < k; ++j) {
                    result[i++] = list[t].get(j);
                }
            }
        }
        return result;
    }
}
