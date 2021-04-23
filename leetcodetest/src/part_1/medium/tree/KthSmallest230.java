package part_1.medium.tree;

public class KthSmallest230 {

    private int val;
    private int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        /*
         * 分析题意：题目要求在二叉搜索树中找第k小的元素，首先我们想到的是要先dfs，但是用哪一种遍历最合适呢？
         * 这里我们要用到一个关键信息点就是二叉搜索树的性质，中序遍历的有序性！就知道应该用中序遍历最合适，
         * 左 -> 根 -> 右 二叉搜索树中左子树最小，其次是根，然后是右子树，就是一个升序数列了。本题要求找第
         * k小，那么我们就从中序最小节点开始计数，当 count == k 时就可以马上结束遍历收敛回去，直接去对应位置
         * 节点值val回去即可
         */
        inOrder(root, k);
        return val;
    }

    private void inOrder(TreeNode node, int k) {
        if(node == null) return;
        inOrder(node.left, k);
        count++;
        if(count == k) {
            val = node.val;
            return;
        }
        inOrder(node.right, k);
    }

}
