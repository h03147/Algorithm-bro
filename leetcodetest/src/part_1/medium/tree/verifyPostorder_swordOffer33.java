package part_1.medium.tree;

public class verifyPostorder_swordOffer33 {

    public boolean verifyPostorder(int[] postorder) {
        /**
         * 分析题意：本题给的条件是二叉搜索树，我们都知道二叉搜索树的特点是，所有的左子树都小于根节点
         * 所有的右子树都大于根节点，故二叉搜索树的中序遍历是单调递增的。但是本题要我们判断二叉搜索树
         * 的后序遍历，左->右->根，就不满足单调性了。
         * 我们进一步分析，还是绕不开二叉搜索树的特性，那现在给了一个正确的后序遍历数组，那么它就有下
         * 面特点：
         * 我们能够快速确定的是根节点的索引位置就是数组的最后一个元素。除最后一个元素外，数组前面的节点
         * 先是左子树的全部节点，然后才是右子树的全部节点。我们可以先从前向后遍历数组，一边遍历一边比较
         * 当前元素值是否都小于最后一个元素值（根节点），当我们碰到第一个不小于根节点的元素的时候，根据
         * 二叉搜索树的规律，它一定是右子树的节点。故此时左右边界已经找到了，然后继续去向后遍历，到最后
         * 一个元素的前一个节点为止，如果都大于根节点，则满足题意，我们继续去递归它的左右子树，如果左右
         * 子树同样满足上述规律，则说明是正确的二叉搜索树后序遍历结果，返回true。
         *
         * 本题我们可以用双指针的思想来解题
         * 继续来分析递归的收敛条件：当递归子树递归到节点个数小于等于1的时候，first指针和last差值要么
         * 为1，要么小于1，此时只有一个节点了没有在继续严重后序遍历的必要性了，故收敛返回true即可。
         * 返回值：
         * 1.左右子树完整，且后序遍历正确，则curIndex会和last相遇。
         * 2.所有左子树递归都正确
         * 3.所有右子树递归都正确
         */
        // 我本来返回false，测试用例为空要返回true，就emmmmmm...
        if(postorder == null || postorder.length == 0) return true;
        return verify(postorder, 0, postorder.length - 1);
    }

    private boolean verify(int[] postorder, int first, int last) {
        if(last - first <= 1) return true;
        int curIndex = first;
        int rootVal = postorder[last];
        while(postorder[curIndex] < rootVal) curIndex++;
        int m = curIndex;
        while(postorder[curIndex] > rootVal) curIndex++;
        return curIndex == last && verify(postorder, first, m - 1) && verify(postorder, m, last - 1);
    }

}
