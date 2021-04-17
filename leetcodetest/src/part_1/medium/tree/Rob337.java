package part_1.medium.tree;

public class Rob337 {

    // // 方法二 动态规划(hashmap版) + dfs(后序遍历)
    // // f表示选择偷当前节点房屋后获得的最高金额
    // Map<TreeNode, Integer> f = new HashMap<>();
    // // g表示选择不偷当前节点房屋后获得的最高金额
    // Map<TreeNode, Integer> g = new HashMap<>();

    public int rob(TreeNode root) {
        // // 方法一 递归 超时
        // if(root == null) return 0;
        // // 偷根节点
        // int val1 = root.val;
        // // 附带递归偷其左孙子和右孙子
        // if(root.left != null) val1 += rob(root.left.left) + rob(root.left.right);
        // if(root.right != null) val1 += rob(root.right.left) + rob(root.right.right);
        // // 不投根节点递归偷其左儿子和右儿子
        // int val2 = rob(root.left) + rob(root.right);
        // return Math.max(val1, val2);

        // // 方法二 动态规划(hashmap版) + dfs(后序遍历)
        // dfs(root);
        // return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));

        // 方法二 动态规划(优化数组版) + dfs(后序遍历)
        // 数组里面下标0表示偷时的最高金额，下标1表示不偷时的最高金额
        int[] rootStatus = dfs1(root);
        return Math.max(rootStatus[0], rootStatus[1]);
    }

    // // 方法二 动态规划(hashmap版) + dfs(后序遍历)
    // private void dfs(TreeNode node) {
    //     if(node == null) return;
    //     dfs(node.left);
    //     dfs(node.right);
    //     f.put(node, node.val + g.getOrDefault(node.left, 0) + g.getOrDefault(node.right, 0));
    //     g.put(node, Math.max(f.getOrDefault(node.left, 0), g.getOrDefault(node.left, 0)) + Math.max(f.getOrDefault(node.right, 0), g.getOrDefault(node.right, 0)));
    // }

    // 方法二 动态规划(优化数组版) + dfs(后序遍历)
    private int[] dfs1(TreeNode node) {
        if(node == null) return new int[] {0, 0};
        int[] left = dfs1(node.left);
        int[] right = dfs1(node.right);
        int selected = node.val + left[1] + right[1];
        int notselected = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[] {selected, notselected};
    }

}
