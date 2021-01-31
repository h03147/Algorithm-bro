package part_1.hard.queue;

import java.util.LinkedList;

/**
 * description: 239. 滑动窗口 双端队列解决超时问题，时间复杂度为O(n)
 */
public class MaxSlidingWindow239 {

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.print("[");
        for(int item : maxSlidingWindow(nums, k))
        {
            if(item == 7) {
                System.out.print(item);
            }else {
                System.out.print(item + "," + " ");
            }
        }
        System.out.print("]");
    }

    private static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length < 2) return nums;
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值(下标)按从大到小排序
        LinkedList<Integer> queue = new LinkedList<Integer>();
        // 结果数组
        int[] result = new int[nums.length-k+1];
        // 遍历nums数组
        for(int i = 0;i < nums.length;i++){
            // 保证从大到小 如果当前队列中的队首值也就是最大值小于等于正在遍历的数，则队列全部弹出
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.pollLast();
            }
            // 添加当前最新的最大值对应的数组下标
            queue.addLast(i);
            // 判断当前队列中队首的值是否有效，如果在窗体外就弹出队首对应的
            // 下标( i-k为窗体的左边界L，i为右边界)
            if(queue.peek() <= i-k){
                queue.poll();
            }
            // 当窗口长度为k时 保存当前窗口中最大值(即已经形成了一个完整窗口后)
            if(i+1 >= k){
                result[i+1-k] = nums[queue.peek()];
            }
        }
        return result;
    }
}
