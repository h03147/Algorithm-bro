package part_1.easy.tree;

import java.util.*;

public class FindMode501 {

    private int curCnt = 1;
    private int maxCnt = 1;
    private TreeNode preNode = null;

    public int[] findMode(TreeNode root) {
        List<Integer> maxCntNums = new ArrayList<>();
        inOrder(root, maxCntNums);
        int[] result = new int[maxCntNums.size()];
        int idx = 0;
        for(int num : maxCntNums) {
            result[idx++] = num;
        }
        return result;
    }

    private void inOrder(TreeNode node, List<Integer> nums) {
        if(node == null) return;
        inOrder(node.left, nums);
        if(preNode != null) {
            if(preNode.val == node.val) {
                curCnt++;
            } else {
                curCnt = 1;
            }
        }
        if(curCnt > maxCnt) {
            maxCnt = curCnt;
            nums.clear();
            nums.add(node.val);
        } else if(curCnt == maxCnt) {
            nums.add(node.val);
        }
        preNode = node;
        inOrder(node.right, nums);
    }

}
