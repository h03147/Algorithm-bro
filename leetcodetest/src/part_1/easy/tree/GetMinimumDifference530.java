package part_1.easy.tree;

public class GetMinimumDifference530 {

    private int minDifference = Integer.MAX_VALUE;
    private TreeNode preNode = null;

    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return minDifference;
    }

    private void inOrder(TreeNode node) {
        if(node == null) return;
        inOrder(node.left);
        if(preNode != null) minDifference = Math.min(minDifference, node.val - preNode.val);
        preNode = node;
        inOrder(node.right);
    }

}
