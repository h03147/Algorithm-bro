package part_1.medium.linkedlist;

public class SplitListToParts725 {

    public ListNode[] splitListToParts(ListNode root, int k) {
        int N = 0;
        ListNode cur = root;
        // 先计算出当前链表的长度，注意这里判断条件是为空的时候才停止也就是要跳到结尾不为空节点
        // 的下一个位置null才结束，故 N = root.size() + 1; 复习一遍
        while(cur != null) {
            N++;
            cur = cur.next;
        }

        // 如果能等分，算出等分后剩余的候补节点
        int mod = N % k;
        // 恰好能等分时，每一个等分链的长度
        int size = N / k;
        // 这里我称为链数组，也就是一个数组里面存储多条链，开辟空间大小为要等分的数量k
        ListNode[] result = new ListNode[k];
        // 初始化的时候我们让cur指针再回到整个链的链头节点上
        cur = root;
        // 外层循环将等分后不为空的链给装入链数组对应下标位置中
        for(int i = 0; cur != null && i < k; ++i) {
            // 初始化的时候把每一个等分链的头节点先存到数组下标对应位置上，相当于创建好了头节点
            result[i] = cur;
            //如果mod不为零即有候补节点，按提议要求，我们优先给前面链分配，在等分长度上加1
            int curSize = size + (mod-- > 0 ? 1 : 0);
            // 把除头节点外剩余节点接到当前头节点的后面(原理这么理解)，实际上只用让指针遍历
            // 到每一个等分链的末尾
            for(int j = 0; j < curSize - 1; ++j) {
                cur = cur.next;
            }
            // 然后做断链操作，让cur继续位动到后面还没遍历到的剩余链表中
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        return result;
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
