package part_1.easy.stackandqueue;

import java.util.Stack;

public class CQueue_swordOffer09 {

    Stack<Integer> in;
    Stack<Integer> out;
    public CQueue_swordOffer09() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void appendTail(int value) {
        in.push(value);
    }

    public int deleteHead() {
        if (out.isEmpty())
            while (!in.isEmpty()) {
                out.push(in.pop());
            }

        if (out.isEmpty()) {
            return -1;
        }
        return out.pop();
    }

}
