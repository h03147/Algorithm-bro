package part_1.easy.tree;

public class IsSymmetric101 {

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        // 如果非空就从根节点按照镜像对称递归按层比较左右子树
        return isSymmetric1(root.left, root.right);
    }

    private boolean isSymmetric1(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;
        if(t1.val != t2.val) return false;
        return isSymmetric1(t1.left, t2. right) && isSymmetric1(t1.right, t2.left);
    }

}
