package part_1.easy.tree;

public class DiameterOfBinaryTree543 {

    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }

    // 根据递归思想，算出每个节点作为根节点其左右子树的最深距离，然后相加找最大值
    private int depth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int l = depth(root.left);
        int r = depth(root.right);
        // 已存在最大长度，和新的对比，新的更大则替换，否则不变
        max = Math.max(max, l + r);
        // 找到每一层递归的最大局部深度
        return 1 + Math.max(l, r);
    }

}
