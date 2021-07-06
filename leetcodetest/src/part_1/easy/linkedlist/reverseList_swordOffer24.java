package part_1.easy.linkedlist;

public class reverseList_swordOffer24 {

    // // 方法一 双指针法
    // public ListNode reverseList(ListNode head) {
    //     if(head == null || head.next == null) return head;
    //     ListNode node, nextNode, newHeadNode;
    //     newHeadNode = null;
    //     node = head;
    //     while(node != null) {
    //         nextNode = node.next;
    //         node.next = newHeadNode;
    //         newHeadNode = node;
    //         node = nextNode;
    //     }
    //     return newHeadNode;
    // }
    // 方法二 头插法
    public ListNode reverseList(ListNode head) {
        ListNode newList = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            head.next = newList.next;
            newList.next = head;
            head = next;
        }
        return newList.next;
    }

}
