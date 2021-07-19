package part_1.easy.tree;

public class IsBalanced110 {

    private boolean result = true;

    public boolean isBalanced(TreeNode root) {
        /*
         * 分析题意：要判断一棵树是不是平衡二叉树，关键在于判断一个二叉树每个节点的左右两个子树的高度差是否大于1，
         * 大于1了就不是平衡二叉树，那说到高度差我们肯定想到了上一个题目求树的高度，我们把所有不为空的节点当作子
         * 问题的根节点算他们左右子树的高然后做差判断是否大于1，既最容易想到的方法就是dfs的递归求解，最后结果要求
         * 返回boolean类型，故我们还需要申明一个变量作为返回结果，这里我封装了递归的方法，所以result需要写共享的
         * 全局变量方便修改。
         */

        // 以当前根节点开始，算出它的左子树右子树高度差，先递归到底，然后反过来自下而上求每颗子数左右子树高度差
        maxDepth(root);
        return result;
    }

    private int maxDepth(TreeNode root) {
        // 如果当前节点作为根节点为空了，就说明当前路径到底了该返回了或者是当前已经非平衡了，无需继续dfs
        if(root == null || !result) {
            return 0;
        }
        // 找到当前节点为根节点时其左子树的高度
        int l = maxDepth(root.left);
        // 同理找到其右子树的深度
        int r = maxDepth(root.right);
        // 按照平衡二叉树的定义，左右子数深度差如果大于1了就是非平衡，result要改成false
        if(Math.abs(l - r) > 1) {
            result = false;
        }
        // 因为我们要求当前节点作为根节点时的最大深度，即它左右子数哪个更深我们就取哪个，
        // 然后高度加1结果传递回上一层，上一层合并以此类推回去
        return 1 + Math.max(l, r);
    }

}
