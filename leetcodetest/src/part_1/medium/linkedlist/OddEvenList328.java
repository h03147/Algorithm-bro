package part_1.medium.linkedlist;

public class OddEvenList328 {

    public ListNode oddEvenList(ListNode head) {
        if(head == null) {
            return head;
        }

        // 第一个节点编号时1(head)，我们把odd指针指到此第一个奇数节点上进行初始化初始化，同理even指针指到
        // 第一个偶数节点编号2(head.next)，另外开辟指针evenHead标记第一个偶数节点，是为了保证在不断地断链
        // 操作过程中保证偶数的头节点被我们一直标记着不丢失，因为最后需要把奇数的最后一个节点与偶数的头节点
        // 相连
        ListNode odd = head, even = head.next, evenHead = even;
        // 链条是按照全部奇数然后全部偶数的顺序排列，故结束调节判断even指针位置是否到结尾即可
        while(even != null && even.next != null) {
            // 让当前奇数节点与下一个奇数节点链接(绝对编号升序链条符合数学规律奇-偶-奇-偶-奇-偶...)
            odd.next = odd.next.next;
            // 让当前奇数指针后移到下一个奇数节点上，解释下这里的原因，因为原来奇数节点的链指向的是下一个偶数
            // 节点，现在我们做断链重连跳过了偶数节点让当前奇数节点的链指向了下一个奇数节点上，
            // 故 odd = odd.next,可以直接让指针跳两个步长到下一个奇数节点上，重复上述操作就把所有奇数节点都
            // 相邻链接上了
            odd = odd.next;

            // 偶数同理
            even.next = even.next.next;
            even = even.next;
        }
        // while循环结束后当前odd指针是指向奇数节点最后一个位置的，而evenHead我们一开始就介绍了它标记在第一个
        // 偶数节点上，故让他们尾首相连，就得到了题目想要的结果
        odd.next = evenHead;
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
