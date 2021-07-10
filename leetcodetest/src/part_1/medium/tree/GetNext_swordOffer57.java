package part_1.medium.tree;

public class GetNext_swordOffer57 {


    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        /**
         * * 题目：二叉树的下一个结点
         * 分析题意：中序遍历的过程：先遍历树的左子树，再遍历根节点，最后再遍历右子树。
         * 所以最左节点是中序遍历的第一个节点。
         * 本题要找的有两种情况
         * 1. 如果一个节点的右子树不为空，那么该节点的下一个节点是右子树的最左节点；
         * 2. 否则，向上找第一个左链接指向的树包含该节点的祖先节点。
         */
        if(pNode.right != null) {
            TreeLinkNode node = pNode.right;
            while(node.left != null) {
                node = node.left;
            }
            return node;
        } else {
            while(pNode.next != null) {
                TreeLinkNode parent = pNode.next;
                if(parent.left == pNode) {
                    return parent;
                }
                pNode = pNode.next;
            }
        }
        return null;
    }


    public class TreeLinkNode {

        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null; // 指向父结点的指针

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
}
