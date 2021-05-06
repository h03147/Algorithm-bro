package part_1.medium.stackandqueue;

import java.util.Stack;

public class DailyTemperatures739 {

    public int[] dailyTemperatures(int[] T) {
        /*
         * 分析题意：这里我们用到了栈的结构，并且栈中存储的是温度数值中的下标
         * 结果数组我们定义为dist[n], 大小n就是温度数组的长度
         * 遍历温度数组，当前遍历下标(记：curIndex)对应温度大于栈顶元素对应下标温度时，说明栈顶元素作为下标对应温
         * 度的下一个比它大的温度数就是当前元素。满足条件，就让栈顶元素(记：preIndex)弹出栈，其就是对应要存储位置
         * 的下标，然后对应下标的结果数组dist[preIndex] = curIndex - preIndex; 这样就巧妙的利用了下标差来当作
         * 下一次升温的天数。
         */
        int n = T.length;
        int[] dist = new int[n];
        Stack<Integer> indexs = new Stack<>();
        for(int curIndex = 0; curIndex < n; ++curIndex) {
            while(!indexs.isEmpty() && T[curIndex] > T[indexs.peek()]) {
                int preIndex = indexs.pop();
                dist[preIndex] = curIndex - preIndex;
            }
            indexs.add(curIndex);
        }

        return dist;
    }

}
