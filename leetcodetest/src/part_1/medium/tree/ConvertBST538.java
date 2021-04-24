package part_1.medium.tree;

public class ConvertBST538 {


    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        traver(root);
        return root;
    }

    private void traver(TreeNode root) {
        if(root == null) return;
        traver(root.right);
        sum += root.val;
        root.val = sum;
        traver(root.left);
    }

}
