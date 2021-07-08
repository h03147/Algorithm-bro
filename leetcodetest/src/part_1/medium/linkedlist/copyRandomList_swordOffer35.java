package part_1.medium.linkedlist;

public class copyRandomList_swordOffer35 {

    public Node copyRandomList(Node head) {
        if(head == null) return head;

        // step 1 并排复制原链表的所有节点，直接放在原相同节点后面
        Node cur = head;
        while(cur != null) {
            Node clone = new Node(cur.val);
            clone.next = cur.next;
            cur.next = clone;
            cur = clone.next;
        }

        // step 2 进一步深度复制原链表所有节点的random链接指向到我们复制的一一对应新节点上
        cur = head;
        while(cur != null) {
            Node cloneRandom = cur.next;
            if(cur.random != null) {
                cloneRandom.random = cur.random.next;
            }
            cur = cloneRandom.next;
        }

        // step 3 复制成功，把新复制的链表从原链表中剥离出来
        cur = head;
        Node cloneNewHead = head.next;
        while(cur.next != null) {
            Node nextNode = cur.next;
            cur.next = nextNode.next;
            cur = nextNode;
        }
        return cloneNewHead;
    }

}
