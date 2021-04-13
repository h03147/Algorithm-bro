package part_1.easy.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth104 {

    public int maxDepth(TreeNode root) {
        // // 方法一 dfs的递归求数高度
        // return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;

        // 方法二 bfs在队列中按层去弹出和加入每层的叶子节点
        if(root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int answer = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size > 0) {
                TreeNode node = queue.poll();
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            answer++;
        }
        return answer;
    }

}
