package part_1.medium.linkedlist;

public class SwapPairs24 {

    public ListNode swapPairs(ListNode head) {
        /*
         * 分析题意：这里要做到两两交换，至少需要四个指针，当前节点，当前节点的前序节点，当前节点的后续节点，
         * 当前后续节点的后续节点，这样我们就可以断链交换了，注意我们这是在真实的操作，带着存储地址一起移动
         * 节点，货真价实，所以对应节点上的指针也是捆绑着一起走的。这点很重要！
         */

        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode pre = node;
        while(pre.next != null && pre.next.next != null) {
            // 指针的定位
            ListNode l1 = pre.next, l2 = pre.next.next;
            ListNode next = l2.next;

            // 开始断链交换
            l1.next = next;
            l2.next = l1;
            pre.next = l2;

            // pre移动到l1指针所在的节点上
            pre = l1;
        }
        return node.next;
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
