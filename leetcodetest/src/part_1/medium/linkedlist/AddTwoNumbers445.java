package part_1.medium.linkedlist;

import java.util.Stack;

public class AddTwoNumbers445 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /*
         * 分析题意：题目要求我们不能对链表进行修改，还不允许翻转，这有点恶心，强行让我们想其他新方法
         * 所以这里原装的不让动的话，那我就只能山寨你，自己创建复制你，那这里也要考虑到加法的运算规则，
         * 从个位开始向前加，并且还要逢10进1，故我们可以用栈的先进后出特性来创造栈实例做加法运算
         */

        Stack<Integer> l1Stack = buildStack(l1);
        Stack<Integer> l2Stack = buildStack(l2);

        ListNode head = new ListNode(-1);
        int carry = 0; // 存储一会加法运算的累加和

        while(!l1Stack.isEmpty() || !l2Stack.isEmpty() || carry != 0) {
            int x = l1Stack.isEmpty() ? 0 : l1Stack.pop();
            int y = l2Stack.isEmpty() ? 0 : l2Stack.pop();
            int sum = x + y + carry;
            // 根据辗转相除法，我们创建临时node用于存储十进制数每一位上的数
            ListNode node = new ListNode(sum % 10);
            // 这里用头插法是因为辗转相除法得到的数的顺序是 个 十 百 ...，和我们正常数的顺序是反的
            // 头插法相当与反转纠正了
            node.next = head.next;
            head.next = node;
            carry = sum / 10;
        }
        return head.next;
    }

    private Stack<Integer> buildStack(ListNode l) {
        Stack<Integer> tempStack = new Stack<>();

        while(l != null) {
            tempStack.push(l.val);
            l = l.next;
        }

        return tempStack;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
