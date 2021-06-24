package part_1.easy.stackandqueue;

import java.util.Stack;

public class MinStack_swordOffer30 {

    Stack<Integer> outStack;
    Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack_swordOffer30() {
        outStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        outStack.push(x);
        minStack.push(minStack.isEmpty() ? x : Math.min(minStack.peek(), x));
    }

    public void pop() {
        outStack.pop();
        minStack.pop();
    }

    public int top() {
        return outStack.peek();
    }

    public int min() {
        return minStack.peek();
    }

}
