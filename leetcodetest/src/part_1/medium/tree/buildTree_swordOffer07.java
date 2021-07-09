package part_1.medium.tree;

public class buildTree_swordOffer07 {

    /**
     * 分析题意：
     * 树的先序遍历顺序为：[ 根节点, [左子树的前序遍历结果], [右子树的前序遍历结果] ]
     * 树的中序遍历顺序为：[ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ]
     *
     * 只要我们在中序遍历中定位到根节点，那么我们就可以分别知道左子树和右子树中的节点数目。
     * 由于同一颗子树的前序遍历和中序遍历的长度显然是相同的，因此我们就可以对应到前序遍历
     * 的结果中，对上述形式中的所有左右括号进行定位。
     * 这样以来，我们就知道了左子树的前序遍历和中序遍历结果，以及右子树的前序遍历和中序遍
     * 历结果，我们就可以递归地对构造出左子树和右子树，再将这两颗子树接到根节点的左右位置。
     *
     * 进一步分析如何快速确定中序遍历中上层根节点的坐标位置
     * 在中序遍历中对根节点进行定位时，一种简单的方法是直接扫描整个中序遍历的结果并找出根
     * 节点，但这样做的时间复杂度较高。我们可以考虑使用哈希表来帮助我们快速地定位根节点。
     * 对于哈希映射中的每个键值对，键表示一个元素（节点的值），值表示其在中序遍历中的出现
     * 位置。在构造二叉树的过程之前，我们可以对中序遍历的列表进行一遍扫描，就可以构造出这
     * 个哈希映射。在此后构造二叉树的过程中，我们就只需要O(1)的时间对根节点进行定位了。
     */

    // 缓存中序遍历数组每个值对应的索引
    private Map<Integer, Integer> indexForInOrder = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for(int i = 0; i < inorder.length; ++i) {
            indexForInOrder.put(inorder[i], i);
        }
        return reConstructBinaryTree(preorder, 0, preorder.length - 1, 0);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        if(preL > preR) return null;
        TreeNode root = new TreeNode(pre[preL]);
        int inIndex = indexForInOrder.get(root.val);
        int leftTreeSize = inIndex - inL; // 中序遍历中左子树的长度
        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
        root.right = reConstructBinaryTree(pre, preL + 1 + leftTreeSize, preR, inL + leftTreeSize + 1);
        return root;
    }

}
