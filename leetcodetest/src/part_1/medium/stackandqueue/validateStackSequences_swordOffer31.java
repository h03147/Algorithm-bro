package part_1.medium.stackandqueue;

import java.util.Stack;

public class validateStackSequences_swordOffer31 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        Stack<Integer> stack = new Stack<>();
        for(int pushIndex = 0, popIndex = 0; pushIndex < n; ++pushIndex) {
            stack.push(pushed[pushIndex]);
            while(popIndex < n && !stack.isEmpty()
                    && stack.peek() == popped[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }

}
