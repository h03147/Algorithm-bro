package part_1.easy.stackandqueue;

import java.util.Stack;

public class MinStack155 {

    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;
    private int min;

    /*
     * 分析题意：本题既要保证出栈的时候，栈顶元素保持原来后进先出的相对位置不变，又要保证随时能拿当前栈中剩下元素
     * 中的最小值，故我们至少需要用两个栈来实现题意的要求，一个栈dataStack正常存取元素即可，另一个栈minStack的
     * 元素数量和dataStack的相同，但是相对位置上存储的是dataStack栈剩下所有元素中的最小值。即可满足题意。
     */

    /** initialize your data structure here. */
    public MinStack155() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        dataStack.push(val);
        min = Math.min(min, val);
        minStack.push(min);
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
        min = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}
