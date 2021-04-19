package part_1.medium.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        // // 方法一 递归写法
        // List<Integer> res = new ArrayList<>();
        // preOrder(root, res);
        // return res;

        // 方法二 非递归写法 我们用栈来实现
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node == null) continue;
            res.add(node.val);
            stack.push(node.right); // 栈先进后出，而我们要根左右，所以先right进再left进取的时候就是前序
            stack.push(node.left);
        }
        return res;
    }

    // // 方法一 递归写法
    // private void preOrder(TreeNode root, List<Integer> res) {
    //     if(root == null) return;
    //     res.add(root.val);
    //     preOrder(root.left, res);
    //     preOrder(root.right, res);
    // }

}
