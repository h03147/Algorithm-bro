package part_1.easy.linkedlist;

import java.util.Stack;

public class reversePrint_swordOffer06 {

    // // 方法一 递归写法
    // List<Integer> tempList = new ArrayList<>();
    public int[] reversePrint(ListNode head) {
        //    // 方法一 递归解法 利用递归现一直遍历到链表结尾，为空后开始反向收敛，此时开始存储val到tempList中，就在
        //    // 反向收敛回去的过程中把val倒序存储到tempList中去了。
        //    ListNode node = head;
        //    recursion(node);
        //    int[] result = new int[tempList.size()];
        //    for(int i = 0; i < tempList.size(); ++i) {
        //        result[i] = tempList.get(i);
        //    }
        //    return result;


        //    // 方法二 新建一个链表用头插法，遍历一遍原链表，生成的新链表就是原链表的逆序链表
        //    ListNode node = head;
        //    ListNode newHead = new ListNode(-1);
        //    int size = 0;
        //    while(node != null) {
        //        ListNode memo = node.next;
        //        node.next = newHead.next;
        //        newHead.next = node;
        //        node = memo;
        //        size++;
        //    }

        //    // 遍历新链表，存储到输出结果数组中
        //    int[] result = new int[size];
        //    int idx = 0;
        //    newHead = newHead.next;
        //    while(newHead != null) {
        //        result[idx++] = newHead.val;
        //        newHead = newHead.next;
        //    }
        //    return result;

        // 方法三 遍历原链表，全部存入栈中，然后弹栈到结果数组即可
        Stack<Integer> stack = new Stack<>();
        ListNode node = head;
        while(node != null) {
            stack.add(node.val);
            node = node.next;
        }
        int[] result = new int[stack.size()];
        int idx = 0;
        while(!stack.isEmpty()) {
            result[idx++] = stack.pop();
        }
        return result;
    }

//    // 方法一 递归写法
//    private void recursion(ListNode node) {
//        if(node != null) {
//            recursion(node.next);
//            tempList.add(node.val);
//        } else {
//            return;
//        }
//    }


    public class ListNode {
        int val;
        ReverseList206.ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
