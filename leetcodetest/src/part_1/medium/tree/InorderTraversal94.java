package part_1.medium.tree;
import java.util.*;

public class InorderTraversal94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        // // 方法一 递归写法
        // List<Integer> res = new ArrayList<>();
        // inOrder(root, res);
        // return res;

        // 非递归Stack方法实现
        // 中序遍历我们需要取得顺序是 left->root->right, 那我们根据栈的特点，我们首先需要让栈顶元素是
        // 最左叶子节点（如果存在），然后中间压的是当前叶子对应根节点（如果存在），最后栈最下面压的是
        // 右叶子节点(如果存在)，从局部到全局都是这样一个规律。
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        // 非前序遍历栈顶就是我们首先要取得根节点，这里我们先去根节点得左子树开始探寻，我们不能在栈顶拿到根节点，
        // 故我们需要创建一个指针标记后去帮我们先拿到左子树节点
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()) {
            // 如果存在左子树保证栈顶放的是左子树节点，不存在就取根节点然后跳出循环我们再去考虑右子树
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // 取出当前栈顶元素并用node指针做标记，有左子树先取左子树然后是根
            TreeNode node = stack.pop();
            res.add(node.val);
            // 如果node存在，即栈不为空，继续让cur跑到node指针开始探寻该节点的右子数重复上述操作
            cur = node.right;
        }
        return res;
    }

    // // 方法一 递归写法
    // private void inOrder(TreeNode root, List<Integer> res) {
    //     if(root == null) return;
    //     inOrder(root.left, res);
    //     res.add(root.val);
    //     inOrder(root.right, res);
    // }

}
