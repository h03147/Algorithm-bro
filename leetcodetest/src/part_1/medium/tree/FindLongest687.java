package part_1.medium.tree;

public class FindLongest687 {

    private int path = 0;

    public int longestUnivaluePath(TreeNode root) {
        // 递归去找同值节点最大深度，初始化从根节点开始尝试
        findLongest(root);
        return path;
    }

    private int findLongest(TreeNode root) {
        if(root == null) return 0;
        // 递归找左子树和root同值路径
        int left = findLongest(root.left);
        // 递归找右子树与root同值路径
        int right = findLongest(root.right);
        // 下面两行合起来找左子数与root与右子树同值路径
        int leftPath = (root.left != null && root.left.val == root.val) ? left + 1 : 0;
        int rightPath = (root.right != null && root.right.val == root.val) ? right + 1 : 0;
        // 比较当前已经存在的最大同值路径和上面三种可能的同值路径情况比较取最大的返回
        // leftPath和rightPath都并不为零 || leftPath为零rightPath不为零 || letfPath不为零rightPath为零
        path = Math.max(path, leftPath + rightPath);
        // 这里是findLongest自己递归自己的调用返回，接受的是left或者right这两种情况，所以要比较左右子数选择
        // 最大的同值路径返回
        return Math.max(leftPath, rightPath);
    }

}
