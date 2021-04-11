package part_1.easy.linkedlist;

public class IsPalindrome234 {

    public boolean isPalindrome(ListNode head) {
        /*
         * 分析题意： O(n) 时间复杂度和 O(1) 空间复杂度，也就是只允许一趟遍历，而且不能另外大于O(1)的开辟空间
         * 那基本就只能原地操作了。一句话概括方法
         * 把当前链表切成两半，把后半段反转，然后比较两半是否相等。
         * 进一步操作细节如下：
         * 这题也用到了快慢指针法，而且是常规的快慢指针，慢指针一次走一个步长，快指针一次走两个步长，同时考虑到
         * 链表长度可能为偶数或者是奇数，故我们初始的时候要把快指针的位置放在慢指针的下一个位置，错开就能同时满
         * 足奇数和偶数长度。
         */

        // 如果为空或者只有一个节点就一定是回文数返回true
        if(head == null | head.next == null) return true;

        // 初始化快指针在慢指针的下一个位置
        ListNode fast = head.next, slow = head;

        // 链表长度为偶数时，fast结束时停留在最后一个不为空的节点上，为奇数时fast结束时停留在null上
        while(fast != null && fast.next != null) {
            // 想象一下快指针每步走的步长都是慢指针的两倍，那当快指针走到结尾的时候，慢指针正好走到
            // 链表长度的一半（链表长度是偶数），或者走到链表长度的一半加一位置(链表长度是奇数)
            slow = slow.next;
            fast = fast.next.next;
        }

        // 因为我们要用head和slow指针分别标记切割后两个链表的头节点，故slow需要指向切割后第二条链
        // 的头节点，如果为偶数需要再后移一位
        if(fast != null) {
            slow = slow.next;
        }
        // 切割操作
        cut(head, slow);
        // 判断切割后两条链是否相等
        return isEquals(head, reverse(slow));
    }

    private void cut(ListNode head, ListNode secondHead) {
        while(head.next != secondHead) {
            head = head.next;
        }
        head.next = null;
    }

    private ListNode reverse(ListNode secondHead) {
        ListNode newHead = null;
        while(secondHead != null) {
            ListNode nextNode = secondHead.next;
            secondHead.next = newHead;
            newHead = secondHead;
            secondHead = nextNode;
        }
        return newHead;
    }

    private boolean isEquals(ListNode l1, ListNode l2) {
        while(l1 != null && l2 != null) {
            if(l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
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
