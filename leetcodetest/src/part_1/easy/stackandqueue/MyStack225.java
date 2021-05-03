package part_1.easy.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列实现栈
 */
public class MyStack225 {

    private Queue<Integer> queue;

    /*
     * 分析题意：在将一个元素 x 插入队列时，为了维护原来的后进先出顺序，需要让 x 插入队列首部。而队列的默认
     * 插入顺序是队列尾部，因此在将 x 插入队列尾部之后，需要让除了 x 之外的所有元素出队列，再入队列。
     */

    /** Initialize your data structure here. */
    public MyStack225() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        int cnt = queue.size();
        while(cnt-- > 1) {
            queue.add(queue.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }

}
