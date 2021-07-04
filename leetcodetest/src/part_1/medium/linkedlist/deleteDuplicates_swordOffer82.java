package part_1.medium.linkedlist;

public class deleteDuplicates_swordOffer82 {

    public ListNode deleteDuplicates(ListNode head) {
        // head为空或者head.next为空的边界判断
        if(head == null || head.next == null) return head;
        ListNode next = head.next;
        // 情况一，head开始就重复了，找到了与当前head相连的所有重复的元素
        if(head.val == next.val) {
            // 进一步判断还有没有重复的元素
            while(next != null && head.val == next.val) {
                next = next.next;
            }
            // 直到找到重复元素后面第一个元素，继续递归判断后面元素的重复性
            return deleteDuplicates(next);
        } else {
            // 当前head不重复，继续递归找下一个，判断后面的节点是否重复，最后不重复的节点，则都和head接上了
            // 如果后面有出现和非head重复的中间重复节点，都删除掉，让只出现一次的元素接到head后面即可
            head.next = deleteDuplicates(head.next);
            return head;
        }
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
