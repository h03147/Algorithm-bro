package part_1.easy.linkedlist;

public class getKthFromEnd_swordOffer22 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head == null) return null;
        ListNode node = head;
        ListNode knode = head;
        while(node != null) {
            if(k <= 0) {
                knode = knode.next;
            }
            k--;
            node = node.next;
        }
        return knode;
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
