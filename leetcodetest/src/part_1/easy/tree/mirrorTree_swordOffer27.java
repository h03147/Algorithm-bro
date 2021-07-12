package part_1.easy.tree;

public class mirrorTree_swordOffer27 {

    public TreeNode mirrorTree(TreeNode root) {
        if(root == null) return root;
        swap(root);
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }

    private void swap(TreeNode root) {
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
    }

}
