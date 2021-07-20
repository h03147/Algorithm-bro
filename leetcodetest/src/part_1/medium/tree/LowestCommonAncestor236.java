package part_1.medium.tree;

public class LowestCommonAncestor236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /*
         * 分析题意：本题不同于二叉搜索树，仅仅是一颗无顺序规律的二叉树，那就需要考虑为空的情况，
         * 如果不为空，我们需要递归遍历所有节点，然后反向返回判断当前节点和p，q之间的关系，如果
         * 满足是公共，那么一定是最近的公共祖先，也就是深度最大的公共祖先，因为我们是dfs之后反
         * 向收敛回去的，从叶子节点自底向上，最先找到的公共祖先符合题意。 20210720 复习一次
         */

        // 先做收敛条件判断，如果root为空题目说了最少右两个节点或者更多，那dfs的时候，root为空了
        // 只能说明到叶子节点了，需要我们反向返回了，根据题目说的，p,q，一定在二叉树上，不在外面，
        // 那root能为空，说明p或q或者q和q在叶子节点上，到最深下届了，我们需要返回收敛了。或者是当
        // 前节点等于p或q中的一个，此时这条路径虽然可能还没到叶子节点，但我们是找公共祖先，一定是
        // 在当前p和q的上面去找才可能找到公共祖先，这也是dfs提前收敛的很好的边界判断，防止资源浪费
        if(root == null || root == p || root == q) return root;

        // 还没找到，就继续dfs左右子树
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right =  lowestCommonAncestor(root.right, p, q);

        // 左右子树其中一个到底了就继续探寻另一颗，反之亦然，或者是左右节点都不为空，说明p,q都找到了
        // 分别在左右子树上，那当前节点一定是最近公共祖先，或者是公共祖先是p，q中的其中一个，另一个
        // 一定存在与公共祖先左右子树中的的一边，才行，否则公共祖先只能继续向更浅的深度继续反向收敛
        // 上去（也就是找到更大的祖先接单判断其左右子树是否包含了p、q）
        return left == null ? right : right == null ? left : root;
    }

}
