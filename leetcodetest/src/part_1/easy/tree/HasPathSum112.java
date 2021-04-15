package part_1.easy.tree;

public class HasPathSum112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        // 如果一条到叶子节点的路径最后能让val == targetSum 则表示刚好等于目标和整数
        if(root.left == null && root.right == null && root.val == targetSum) return true;
        // 否则没到叶子节点就左右继续递归就行了
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

}
