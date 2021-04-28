package part_1.easy.tree;

import java.util.*;

public class FindTarget653 {

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();
        inOrder(root, nums);
        int s = 0, h = nums.size() - 1;
        while(s < h) {
            int sum = nums.get(s) + nums.get(h);
            if(sum == k) {
                return true;
            } else if(sum < k) {
                s++;
            } else {
                h--;
            }
        }
        return false;
    }

    private void inOrder(TreeNode root, List<Integer> nums) {
        if(root == null) return;
        inOrder(root.left, nums);
        nums.add(root.val);
        inOrder(root.right, nums);
    }

}
