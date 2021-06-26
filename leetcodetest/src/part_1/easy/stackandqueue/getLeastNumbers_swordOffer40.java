package part_1.easy.stackandqueue;

import java.util.PriorityQueue;

public class getLeastNumbers_swordOffer40 {

    public int[] getLeastNumbers(int[] arr, int k) {
        if(k > arr.length || k <= 0) {
            return new int[0];
        }
        // 用Lambda表达式把默认小顶堆换成大顶堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for(int num : arr) {
            maxHeap.add(num);
            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        int[] result = new int[maxHeap.size()];
        int index = 0;
        for(int num : maxHeap) {
            result[index++] = num;
        }
        return result;
    }

}
