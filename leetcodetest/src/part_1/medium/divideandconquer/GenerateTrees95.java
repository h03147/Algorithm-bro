package part_1.medium.divideandconquer;

import java.util.ArrayList;
import java.util.List;

public class GenerateTrees95 {

    public static void main(String[] args) {
        System.out.println(generateTrees(3));
    }

    public static List<TreeNode> generateTrees(int n) {
        /*
         * 分析题意：猛的一看，这不就是层序遍历吗？BFS算法实现就就行，但是这么想你就会被困住，其实你应该去
         * 分析二叉搜索树的性质，找一个节点为根（root）节点，所有左子树都比铬镍电小，所有右子树都比根节点大
         * ，然后要输出所有可能的树而不是随机一个树。我们可以用一个List来存储所有的树的输出，共有n个节点，
         * 根节点的值（root）假设为x，那么左子树的结合为，[1, x-1],右子树的集合为[x + 1, n], 然后利用递归
         * 的思想来实现即可。
         */
        if(n == 0) {
            return new ArrayList<>();
        }
        return buildTree(1, n);
    }

    // 构建二叉搜索树的代码
    private static List<TreeNode> buildTree(int start, int end) {
        // 为结果集开辟空间
        List<TreeNode> allTrees = new ArrayList<>();
        // 递归到子树为空的时候
        if(start > end) {
            allTrees.add(null);
            return allTrees;
        }

        // 递归所有可能的根节点
        for(int i = start; i <= end; ++i){
            List<TreeNode> leftTrees = buildTree(start, i - 1); // 递归左子树
            List<TreeNode> rightTrees = buildTree(i + 1, end); // 递归右子树

            // 把所有可能的左右子数拼接到对应根节点上
            for(TreeNode left : leftTrees) {
                for(TreeNode right: rightTrees) {
                    // 当前根节点
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    allTrees.add(root);
                }
            }
        }
        return allTrees;
    }
    private static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

}
