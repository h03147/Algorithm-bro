package part_1.medium.tree;

import part_1.medium.linkedlist.OddEvenList328;

public class SortedListToBST109 {

    public TreeNode sortedListToBST(ListNode head) {
        /*
         * 分析题意：本题较上一题从数组中至顶向下构建平衡二叉搜索数而言难度加大了，难在链表每一次找节点都只能从头开始
         * 遍历，而数组则可以直接读取到任意位置下标对应的值。但这样也不能阻止我们至顶向下，最先找到全局根节点
         * (当前节点比其左子树节点值都大比其右子树节点值都小，刚刚好等分这个链表两边)，然后这个链表两边我们同样从子链
         * 的链头开始找到子链的中间点值让他等分左右两边的节点(因为是升序链表故满足二叉搜索树中序遍历逆向过程)，那么这
         * 题难点就难在我们如何在每一趟dfs的时候都正好找到当前链表中的最中间节点值呢？
         * 于是我们引入了前面我们学过的快慢指针法，让快指针初始的时候在慢指针下一个位置，然后同步出发，慢指针一次移动
         * 一个步长，快指针一次移动两个步长，那么当快指针到达链表尾巴时，慢指针正好到达中间节点的前面一个节点位置，
         * 于是就达到了和数组中每一趟都找到当前全局中间节点一样的效果。
         * 总结：一般涉及到链表修改操作时，我们想达到一趟遍历就找到我们需要的查找或者删除或者修改操作位置时，通常先想
         * 到的是快慢指针来达到这么目的(回想一下之前刷题删除第i个节点，修改链找是否存在环操作都用到了快慢指针法)。
         */

        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);
        ListNode preMid = cutPreMid(head);
        ListNode mid = preMid.next;
        preMid.next = null;
        TreeNode t = new TreeNode(mid.val);
        t.left = sortedListToBST(head);
        t.right = sortedListToBST(mid.next);
        return t;
    }

    // 封装方法：遍历找到以当前节点为头节点的链中的全局中间节点的前一个节点并返回
    private ListNode cutPreMid(ListNode head) {
        ListNode pre = head;
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return pre;
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
