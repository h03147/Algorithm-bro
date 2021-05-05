package part_1.easy.stackandqueue;

import java.util.Stack;

public class IsValid20 {

    public boolean isValid(String s) {

        /*
         * 分析题意：如果题目给的测试用例都是严格成对左右闭合出现，或者是由内向外闭合的，那我们就返回true，怎样的结构
         * 能正好同时满足这俩种情况呢，欸，这个时候我们想到了栈，我们遍历s字符换种的每一个字符，每次只让栈能push进
         * 左括号，然后让下一个最先遍历出现的右括号字符和当前栈顶的弹出做一个闭合并且类型一致的匹配，如果最后能完全匹配
         * 成功，那栈肯定是清空了，但是中途如果出现任意一个左括号和右括号闭合且类型一致匹配失败，都得返回false结束方法
         * 反之如果先出现了右括号，那栈肯定一开始就是空的了，也返回false。
         */

        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) {
                    return false;
                }
                char cStack = stack.pop();
                boolean b1 = c == ')' && cStack != '(';
                boolean b2 = c == ']' && cStack != '[';
                boolean b3 = c == '}' && cStack != '{';

                if(b1 || b2 || b3) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

}
