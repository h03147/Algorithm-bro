package part_1.easy.linkedlist;

import org.w3c.dom.ls.LSOutput;

import java.util.LinkedList;

public class GetIntersectionNode160 {

    public  ListNode head;
    public  ListNode current;

    public static void main(String[] args) {
        int[] A = {4, 1, 8 ,4, 5};
        int[] B = {5, 0, 1, 8 ,4, 5};

        GetIntersectionNode160 L1 = new GetIntersectionNode160();
        GetIntersectionNode160 L2 = new GetIntersectionNode160();
        GetIntersectionNode160 L3 = new GetIntersectionNode160();
        // 装进链表
        for(int data1 : A) {
            L1.addnode(data1);
        }
        for(int data2 : B) {
            L2.addnode(data2);
        }


        L1.printList(L1.head);
        System.out.println();
        L1.printList(L2.head);
        System.out.println();
        ListNode headA = L1.head;
        ListNode headB = L2.head;
        System.out.println(L3.getIntersectionNode(headA, headB));
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /*
         * 分析题意：如果两个链表有交点，那么从交点开始后面的所有节点一直到结尾都相等，这个
         * 前提条件很重要，理解了就知道本题我们就是再找最长相交连续的子链。
         * 假设当前有两条链 A 和 B
         * 设 A 的长度为 a + c，B 的长度为 b + c，其中 c 为尾部公共部分长度，可知
         * a + c + b = b + c + a。
         * 这里让等式两边都移除c得到：a + b = b + a，相当于把两个可能长短不一样的链
         * 互相加上对方补到长度一样，这样如果右相交的部分就恰巧会相遇
         * 当访问 A 链表的指针访问到链表尾部时，令它从链表 B 的头部开始访问链表 B；
         * 同样地，当访问 B 链表的指针访问到链表尾部时，令它从链表 A 的头部开始访问
         * 链表 A。这样就能控制访问 A 和 B 两个链表的指针能同时访问到交点。
         * 如果不存在交点，那么 a + b = b + a，以下实现代码中 l1 和 l2 会同时为 null，从而退出循环。
         */
        ListNode L1 = headA, L2 = headB;
//        System.out.println(L1.next.next.val == L2.next.next.next.val);
//        System.out.println(L1.next.next.next.next.next);

        // while循环判断条件有点毛病，new的俩个对象，好像L1和L2不能相等，暂时没找到解决方案，如果有欢迎留言，十分感谢！
        while(L1 != L2) {
//            L1 = (L1 == null) ? headB : L1.next;
//            L2 = (L2 == null) ? headA : L2.next;
//            System.out.println(L1 == L2);
            if(L1 == null) {
                L1 = headB;
                System.out.println("*L1 " + L1.val);
            } else {
                L1 = L1.next;
                if(L1 != null) {
                    System.out.println("@L1 " + L1.val + "---" + L1);
                }
            }
            if(L2 == null) {
                L2 = headA;
                System.out.println("*L2 " + L2.val);
            } else {
                L2 = L2.next;
                if(L2 != null) {
                    System.out.println("@L2 " + L2.val + "---" + L2);
                }
            }
        }
        return L1;
    }

    // 添加节点
    public void addnode(int data) {
        if (head == null) {
            head = new ListNode(data);
            current=head;
        }
        else {
            current.next=new ListNode(data);
            current=current.next;//移位
        }
    }

    //遍历循环，打印链表的元素
    public  void printList(ListNode l) {
        if(l==null) return;
        current=l;
        if(current!=null){
            System.out.print(current.val+"\t");
            current=current.next;
            printList(current);//递归调用
        }
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
