package part_1.easy.tree;

public class SortedArrayToBST108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        /*
         * 分析题意：本题逆向分析下，我们要构建一个二叉搜索树，既然给你一个有序的升序序列，那我们回想一下
         * 二叉搜索树的中序遍历不就是一个升序序列吗，左-根-右，那这个中序遍历序列最中间的值满足左右等分该
         * 值左右两边的值，然后我们至顶向下，让当前中间节点作为其左右子树的根节点，左右两边继续二分等分递归
         * 下去，即为我们想要的结果(就是二叉搜索树中序遍历的一个逆过程分析，自底向上反过来自顶向下)
         */
        return nums == null ? null : buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int l, int h) {
        if(l > h) return null;
        int mid = l + (h - l) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, l, mid - 1);
        root.right = buildTree(nums, mid + 1, h);
        return root;
    }

}
