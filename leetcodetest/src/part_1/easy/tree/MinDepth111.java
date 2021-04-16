package part_1.easy.tree;

public class MinDepth111 {

    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        // 非空就左右子树都递归，到底就收敛回来
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        // 任意一个节点先到叶子节点后就开始反向收敛做节点的记录
        if(left == 0 || right == 0) return left + right + 1;
        // 如果最后收敛完毕了那就比较根节点到左右子数叶子节点的路径长度，取最小的那一个
        return Math.min(left, right) + 1;
    }

}
