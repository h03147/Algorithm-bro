package part_1.easy.tree;

public class PathSum3_437 {

    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        // 从根节点开始向下找或者从其他非根节点开始向下找
        int result = pathSumStartWithRoot(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
        return result;
    }

    private int pathSumStartWithRoot(TreeNode root, int targetSum) {
        if(root == null) return 0;
        // 以当前节点作为起始点让路径和先归0，重新开始向下找路径和是否与targetSum匹配
        int result = 0;
        if(root.val == targetSum) result++;
        // 探索当前节点向下所有左右子树，targetSum与对应值做差，递归到二者相等记录找到一条路径，探底后马上收敛
        result += pathSumStartWithRoot(root.left, targetSum - root.val) + pathSumStartWithRoot(root.right, targetSum - root.val);
        return result;
    }

}
