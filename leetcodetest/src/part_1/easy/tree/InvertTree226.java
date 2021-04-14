package part_1.easy.tree;

public class InvertTree226 {

    public TreeNode invertTree(TreeNode root) {
        /*
         * 分析题意：一句话解释，让当前节点左儿子等于右儿子，右儿子等于左儿子，递归完事了。没错！
         * 这就是一个简单的swap，两数交换位子。
         */
        if(root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

}
