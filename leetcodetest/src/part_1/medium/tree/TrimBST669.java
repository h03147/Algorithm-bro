package part_1.medium.tree;

public class TrimBST669 {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        /*
         * 分析题意：本题需要对树进行裁剪操作，如果不满足题意范围的节点值对应的节点，我们就需要做中断和重连接的操作
         * 这里的断开重连操作可以类比我们前面的链表断开重连来理解。然后再来分析树的结构，是一颗搜索二叉树，那根据搜
         * 索二叉树的性质，比当前节点值大的节点一定在该节点右子树范围内取探寻，比当前节点值小的节点在左子树范围内去
         * 探寻(题目规定节点值唯一，也就是不存在重复值的节点)，那我们尝试用dfs探寻的时候每次比较都可以筛选淘汰当前
         * 节点相连的一半的子树节点，只去探寻在(low, high)内的一边子树即可，到底后返回裁剪即可。
         * 也就是说我们只保留值在 low ~ high 之间的节点即可。
         */

        // 每日一趟dfs先判断当前接单是否为空，为空说明到底了开始收敛返回，不用进行后续操作
        if(root == null) return null;
        // 如果当前节点不在 low ~ high 范围内就裁剪掉范围外的那一边(包括当前节点不满足在范围内也一起裁剪掉)，收敛
        // 返回拼接其满足范围内的那一边子树节点给它的父亲节点，防止断裂丢失，组成一颗新的搜索树
        if(root.val > high) return trimBST(root.left, low, high);
        if(root.val < low) return trimBST(root.right, low, high);

        // 在范围内的节点就证明在 low ~ high 之间，继续dfs探寻他的左右孩子节点即可
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }

}
