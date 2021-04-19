package part_1.medium.tree;
import java.util.*;

public class PostorderTraversal145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        // // 方法一 递归实现
        // List<Integer> res = new ArrayList<>();
        // postOrder(root, res);
        // return res;

        // 非递归Stack方法实现
        // 我们分析下前序非递归Stack写法，顺序是 root->left->right, 现在我们需要 left->right->root
        // 是不是可以把前序的 left 和 right 对调后变成 root->right-left
        // 然后反转变成 left->right->root
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node == null) continue;
            res.add(node.val);
            stack.push(node.left);
            stack.push(node.right);
        }
        Collections.reverse(res);
        return res;
    }

    // // 方法一 递归实现
    // private void postOrder(TreeNode root, List<Integer> res) {
    //     if(root == null) return;
    //     postOrder(root.left, res);
    //     postOrder(root.right, res);
    //     res.add(root.val);
    // }

}
