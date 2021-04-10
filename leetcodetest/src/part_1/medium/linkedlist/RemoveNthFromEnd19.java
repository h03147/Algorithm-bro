package part_1.medium.linkedlist;

public class RemoveNthFromEnd19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        /*
         * 分析题意：本题需要介绍的一个方法叫快慢指针法，和传统意义的快慢指针不一样，这里的快慢两个指针
         * 每一次移动的步长是一样的，只是快指针先走n个步长替还没出发的慢指针先把n长度的距离量好，等量好
         * 快指针也不用回来，站在它量好的距离末端，此时慢指针开始从head出发，和快指针同步向后移动，当
         * 快指针移动到结尾为空结束循环。而此时刚刚一同出发的慢指针是不是刚好就走了
         * linkedlist.size() - n个步长，恰好落到倒数第n个节点前一个位置，此时我们就可以让慢指针的next
         * 指向慢指针的next.next这样就把倒数第n个节点给删除出去了。
         */
        ListNode fast = head;
        while(n-- > 0) {
            fast = fast.next;
        }
        // 这里是边界条件判断，如果当前快指针指向的位置为空，可能是n = linkedlist.size()，fast指针直
        // 接到底了，slow指针指向head，直接让slow = head.next即可跳过head达到删除的目的
        if(fast == null) return head.next;
        ListNode slow = head;
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 做断链删除操作
        slow.next = slow.next.next;
        return head;
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
