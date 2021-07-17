package part_1.easy.tree;

public class kthLargest_swordOffer54 {

    private int cnt = 0;
    private int ret;
    public int kthLargest(TreeNode root, int k) {
        inOrder(root, k);
        return ret;
    }

    private void inOrder(TreeNode node, int k) {
        if(node == null || cnt >= k) return;
        inOrder(node.right, k);
        cnt++;
        if(cnt == k) {
            ret = node.val;
        }
        inOrder(node.left, k);
    }

}
