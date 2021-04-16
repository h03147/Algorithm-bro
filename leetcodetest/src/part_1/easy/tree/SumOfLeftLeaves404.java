package part_1.easy.tree;

public class SumOfLeftLeaves404 {

    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        // 当前节点左子数如果是叶子节点那就把该左叶子节点的值加上右子树继续递归找右子树可能的左叶子节点值
        if(isLeaf(root.left)) return root.left.val + sumOfLeftLeaves(root.right);
        // 当前节点左子树不是叶子节点就继续其左右子树找到可能的左叶子节点就把其节点值加起来
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    private boolean isLeaf(TreeNode node) {
        if(node == null) return false;
        return node.left == null && node.right == null;
    }

}
