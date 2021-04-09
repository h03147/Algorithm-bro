package part_1.easy.linkedlist;

public class ReverseList206 {

    public ListNode reverseList(ListNode head) {
        // // 方法一 反转链表的递归写法
        // if(head == null || head.next == null) {
        //     return head;
        // }
        // // head不为空，我们就把head节点下一个节点暂时存储起来
        // ListNode next = head.next;
        // // 把下一个节点作为新的head(newHead)递归，进一步探寻head后面是否还有新节点，
        // // 一直递归到最深一层后head.next = null,就开始返回上一层了
        // ListNode newHead = reverseList(next);
        // // 每一层返回后都把next节点的next箭头指向他前面的head节点上，也就是相当于把
        // // next节点作为新head，head节点当作新head节点的next节点建立连接
        // next.next = head;
        // // 把旧的head指向next节点的箭头断开，和上一行代码一同构成完整的箭头反转过程
        // head.next = null;
        // // newHead最终会遍历到原链表最后一个不为null的节点并停留在那里，等待完整的
        // // 反转链表被建立完ruturn最终合并后的结果
        // return newHead;

        // 方法二 反转链表的迭代写法

        // 我们需要三个指针分别保存，当前节点，当前节点的前序节点，当前节点的后续节点，这样
        // 才能保证在修改链的操作中不会丢失原链条导致还没到结尾遍历就中断了

        // 初始化当前节点的前序节点
        ListNode prev = null;
        //当前节点初始化从head开始
        ListNode cur = head;

        while(cur != null) {
            // 根据滚动规则，每次先找到当前节点的后续节点
            ListNode nextTemp = cur.next;
            // 开始做断链反转操作
            cur.next = prev;
            // 让前序节点向后移动到当前节点
            prev = cur;
            // 让当前节点向后移动到下一个节点
            cur = nextTemp;
        }
        // 当遍历到结尾时prev移动到末尾节点，cur移动到null了
        return prev;
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
