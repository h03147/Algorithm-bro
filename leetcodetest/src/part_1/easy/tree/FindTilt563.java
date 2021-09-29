package part_1.easy.tree;

public class FindTilt563 {

    int total = 0;
    public int findTilt(TreeNode root) {
        dfs(root);
        return total;
    }

    private int dfs(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        total += Math.abs(left - right);
        return right + left + node.val;
    }

}
