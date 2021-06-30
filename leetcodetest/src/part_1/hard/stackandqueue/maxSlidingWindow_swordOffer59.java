package part_1.hard.stackandqueue;

import java.util.PriorityQueue;

public class maxSlidingWindow_swordOffer59 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        /**
         * 分析题意：题目描述的相当于要你在一个动态更新的大小为k的数组中找到最大值，涉及到动态存取
         * 一组数中的最值问题，我们优先想到用堆来实现，本题要取最大值，故我们尝试用大顶堆来求解，
         * 我们可以维护一个大小为k的堆，然后滑动窗口在数组中向右移动的时候把堆中最左边即将离开
         * 滑动窗口的旧元素删除，即将新到达窗口的元素加入到堆中，这样就能保证堆顶永远是当前滑动
         * 窗口的最大值，及时的添加到结果数组中，遍历结束返回结果即可。
         */
        int[] result = new int[nums.length - k + 1];
        if(k > nums.length || k < 1) {
            return new int[]{ };
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for(int i = 0; i < k; ++i) {
            heap.add(nums[i]);
        }
        int index = 0;
        result[index++] = heap.peek();
        for(int i = 0, j = i + k; j < nums.length; ++i, ++j) {
            heap.remove(nums[i]);
            heap.add(nums[j]);
            result[index++] = heap.peek();
        }
        return result;
    }

}
