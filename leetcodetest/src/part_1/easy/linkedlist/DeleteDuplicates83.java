package part_1.easy.linkedlist;

public class DeleteDuplicates83 {

    public ListNode deleteDuplicates(ListNode head) {

        /*
         * 分析题意：一条链，而且有序，那一趟遍历就行，需要一个指针，如果当前节点和当前节点的下一个节点相等
         * 我们就把当前节点与下一个节点的指向箭头给断开让其链接到当前节点的下一个节点的下一个节点，否则当
         * 前节点后移就行了，当前节点移动到结尾，下一个节点为空就到底了。
         * 递归就是先不断链，直接到底，再倒车只要倒过来第一个不重复节点，跳过除第一个外和第一个节点相等的
         * 节点。
         * 迭代的思想就是，只保留第一个正向过去的不重复节点，看到重复的当场就做个了断，到结尾就结束了。
         */

        // // 方法一 递归
        // if(head == null || head.next == null) return head;
        // head.next = deleteDuplicates(head.next);
        // return head.val == head.next.val ? head.next : head;

        // 方法二 迭代
        if(head == null || head.next == null) return head;

        ListNode cur = head;
        while(cur.next != null) {
            if(cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
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
