package part_1.easy.tree;

public class IsSubtree572 {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null) return false;
        // s是自身的一颗子树等于t或者递归根节点的左子数去找子树等于t或者递归根节点的右子数去找子树等于t
        return isSubtreeWithRoot(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSubtreeWithRoot(TreeNode s, TreeNode t) {
        // 子树匹配查找过程中s中当前节点位置应该和t中当前节点位置是同步的并且相对位置相同
        // 那么如果s和t同时为空了，说明正好至上向下到叶子节点之后完全匹配返回true
        if(s == null && t == null) return true;
        // 两者其中一个先到叶子节点之后不同步结束则匹配失败返回false
        if(s == null || t == null) return false;
        // 匹配过程中任意一个节点里的值不相等也匹配失败返回false
        if(s.val != t.val) return false;
        // 如果当前节点匹配成功，继续向下递归他的左右子数节点，同步进行，左右子数有一个节点位置匹配失败
        // 在and条件下最终返回的结果都是false
        return isSubtreeWithRoot(s.left, t.left) && isSubtreeWithRoot(s.right, t.right);
    }

}
