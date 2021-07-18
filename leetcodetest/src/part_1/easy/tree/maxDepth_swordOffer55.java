package part_1.easy.tree;

public class maxDepth_swordOffer55 {

    public int maxDepth(TreeNode root) {
        // // 方法一 dfs
        // return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));

        // 方法二 bfs
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int ret = 0;
        while(!queue.isEmpty()) {
            int n = queue.size();
            while(n > 0) {
                TreeNode node = queue.poll();
                // if(node == null) continue;
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
                n--;
            }
            ret++;
        }
        return ret;
    }

}
