package part_1.easy.linkedlist;

import java.util.List;

public class MergeTwoLists21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // // 方法一 递归写法
        // // l1 or l2 任意一个为空，返回另一个不为空的即可
        // if(l1 == null) return l2;
        // if(l2 == null) return l1;

        // if(l1.val < l2.val) {
        //     l1.next = mergeTwoLists(l1.next, l2);
        //     return l1;
        // } else {
        //     l2.next = mergeTwoLists(l1, l2.next);
        //     return l2;
        // }

        // 方法二 迭代写法
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;

        while(l1 !=null && l2 != null) {
            if(l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = (l1 != null) ? l1 : l2;
        return preHead.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
