package part_1.easy.linkedlist;

public class getIntersectionNode_swordOffer52 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /**
         * 分析题意：设 A 的长度为 a + c，B 的长度为 b + c，其中 c 为尾部公共部分长度，
         * 可知 a + c + b = b + c + a。
         * 如果两个人有缘分的话，那么他们必定会相遇~
         */
        ListNode l1 = headA, l2 = headB;
        while(l1 != l2) {
            l1 = (l1 == null) ? headB : l1.next;
            l2 = (l2 == null) ? headA : l2.next;
        }
        return l1;
    }

}
