package part_1.medium.stackandqueue;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElements503 {

    public int[] nextGreaterElements(int[] nums) {
        /*
         * 分析题意：这题和我们上一题(739.温度上升)那题差异在于需要记录的不是下一个更大数之间的间隔，而是获得下一个
         * 更大数的值，并且数组是循环数组，但是我们依然可以用栈来实现找到刚好比当前数大的下一个数是谁，模板不变，只是
         * 返回结果的内容由原来的间隔天数变成了这个数字之后的第一个比它更大的数。
         */
        int n = nums.length;
        int[] dist = new int[n];
        Stack<Integer> preStack = new Stack<>();
        Arrays.fill(dist, -1);
        for(int i = 0; i < n * 2; ++i) {
            int num = nums[i % n];
            while(!preStack.isEmpty() && nums[preStack.peek()] < num) {
                dist[preStack.pop()] = num;
            }
            if(i < n) {
                preStack.push(i);
            }
        }
        return dist;
    }

}
