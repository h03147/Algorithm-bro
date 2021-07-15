package part_1.medium.tree;

public class treeToDoublyList_swordOffer36 {

    // 中序遍历，声明两个指针，pre指向当前节点的前序节点，head指向双向链表全局头结点位置
    Node pre, head;
    public Node treeToDoublyList(Node root) {
        // 边界值判断
        if(root == null) return null;
        // 中序遍历 递归二叉搜索树
        inOrder(root);

        // 最后首尾相连，形成环形链表
        head.left = pre;
        pre.right = head;

        // 返回头结点
        return head;
    }

    private void inOrder(Node cur) {
        // 到叶子了开始收敛
        if(cur == null) return;
        // 先递归左子树
        inOrder(cur.left);

        // 根据二叉搜索树中序遍历的顺序性
        // 取当前节点作为根节点，向前(left)的节点比他小，向后(right)的节点比他大

        if(pre == null) {
            // 刚开始第一个节点没有前序节点，故pre为空，我们先让head做标记，方便后面返回结果
            head = cur;
        } else if(pre != null) {
            // 如果pre不为空就是非首节点，为中间节点，此时pre指向了上一个节点，
            // 我们让上一个节点的右指针指向当前节点
            pre.right = cur;
            // 让当前节点的左指针指向上一个节点，也就形成了双向链表
            cur.left = pre;
        }
        // 让pre指针后移一位，保存当前节点，方便遍历下一个节点和当前节点继续连接
        pre = cur;
        // 最后递归右子树
        inOrder(cur.right);
    }

}
