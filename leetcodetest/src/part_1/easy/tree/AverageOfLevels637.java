package part_1.easy.tree;

import java.util.*;

public class AverageOfLevels637 {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> avgResult = new ArrayList<>();
        if(root == null) return avgResult;
        // 根据队列先进先出的特点达到层序遍历的特点，并且至上而下从左向右
        Queue<TreeNode> queue = new LinkedList<>();
        // 第一层是根节点
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            // 下面size要做减法，但是我们这里每一层个数要临时存储方便一会做求每一层平均值的除数
            int tempSize = size;
            // 累加每一层节点个数，当被除数
            double sum = 0;
            // 只要当前层节点还没取完就不停的从队头取节点
            while(size > 0) {
                TreeNode node = queue.poll();
                sum += node.val;
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
                size--;
            }
            // System.out.println(sum);
            double tempAvgOfLevel = sum / tempSize;
            avgResult.add(tempAvgOfLevel);
        }
        return avgResult;

    }

}
