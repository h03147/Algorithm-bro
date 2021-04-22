package part_1.medium.tree;

import java.util.*;

public class FindBottomLeftValue513 {

    public int findBottomLeftValue(TreeNode root) {
        /*
         * 分析题意：要求左下角的值，并且题目描述的左下角指的是最深的一层的第一个左节点。那既然要考虑到层次，所以
         * 我们优先想到层序遍历，可以使用队列来实现
         */
        Queue<TreeNode> queue = new LinkedList<>();
        // 题目规定根节点不为空
        queue.offer(root);
        // 按层入队和出队
        while(!queue.isEmpty()) {
            // 保证root指针最后指向从队列出队的最后一个不为空的节点
            root = queue.poll();
            // 根据队列后进后出的原则，我们要最后取到的是左节点，故先让右子树先进队列，左子树后进去
            if(root.right != null) queue.offer(root.right);
            if(root.left != null) queue.offer(root.left);
        }
        // 循环结束后root就指向了最深层的第一个左下角的值了
        return root.val;
    }

}
