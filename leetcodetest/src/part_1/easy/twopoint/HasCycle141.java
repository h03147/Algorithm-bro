package part_1.easy.twopoint;

public class HasCycle141 {

    public static void main(String[] args) {
        ListNode head =  new ListNode();
        head.add(1);
        head.add(2);
        System.out.println(hasCycle(head));
    }

    /*
     * 分析题意
     * 首先这题常规思路是打点标记标记法就行了，也就是一个指针从头到位遍历一边list
     * 每次把访问过的节点都做一个标记，标示已经走过了，每次走走一个节点判断一次该
     * 节点访问过没，如果链表有环的话那么必然会走到之前访问过的节点。
     * 首先我们来看一下常规思路的代码实现
     *
     *
     * 接下来分析下快慢指针的思想
     * 同一个链表我们用两个指针都指向表头，然后慢指针每次只向后走一个节点，快指针一
     * 次走两个节点，如果没有环，快指针只用了链表长度一半的时间就到终点了，返回false
     * 如果有环，此时就变成快指针先找到环的入口，然后在环里面转圈，等待满指针进去，
     * 由于快指针每次都比满指针多走一步，所以在环中就相当于环形赛道，快指针超满指针
     * 一圈后他们必然会相遇，相遇则证明有环，返回true
     */
    public static boolean hasCycle(ListNode head) {
        // 方法一 常规方法，记录每个访问过的点
        // 最好想到的就是hashset嘛
        // HashSet<ListNode> visited_Node = new HashSet<>();
        // while(head != null){
        //     if(!visited_Node.add(head)) {
        //         return true;
        //     }
        //     head = head.next;
        // }
        // return false;

        // 不讲武德的方法
//        while(head != null) {
//            if(head.data == Integer.MAX_VALUE) {
//                return true;
//            } else {
//                head.data = Integer.MAX_VALUE;
//            }
//            head = head.next;
//        }
//        return false;

        // 快慢指针法
         if(head == null) {
             return false;
         }
         // ListNode slow = head, fast = head;
         // do {
         //     if(fast == null || fast.next == null) {
         //         return false;
         //     }
         //     slow = slow.next;
         //     fast = fast.next.next;
         // }while(slow != fast);
         ListNode slow = head, fast = head.next;
         while(slow != fast) {
             if(fast == null || fast.next == null) {
                 return false;
             }
             slow = slow.next;
             fast = fast.next.next;
         }
         return true;
    }

    private static class ListNode {
        //为了方便,这两个变量都使用pub1ic,
        //存放数据的变量,直接为int型
        public int data;
        //存放结点的变量,默认为nu11
        public ListNode next;

        //构造方法,在构造时就能够给data赋值
        public ListNode() {
//       给个空参构造方法
        }

        public ListNode(int data) {
            this.data = data;
        }

        public int getdata() {
            return this.data;
        }

        //添加节点
        public void add(int newdata) {
            ListNode newNode = new ListNode(newdata);
            if (this.next == null) {
                this.next = newNode;
            } else {
                this.next.add(newdata);
            }
        }

        //输出
        public void print() {
            System.out.print(this.data + "-->");
            if (this.next != null) {
                this.next.print();
            }
        }
    }
}
