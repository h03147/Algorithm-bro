package part_1.easy.tree;

public class FindSecondMinimumValue671 {

    public int findSecondMinimumValue(TreeNode root) {
        /*
         * 分析题意：先来分析树的特点，根节点一定是全局最小点，因为所有节点的val都他左右孩子(如果存在)中更小的那一个
         * 继承上来的。并且这个节点要么没孩子，有孩子一定是左右孩子都有。题目要求我们去找第二小的值，也就是如果有孩子，
         * 就去孩子里面dfs找到一个比根节点值大但是不大于其他所有节点的值。按照规律，我们向下dfs找的值一定是，要么等于
         * 当前节点值要么大于当前节点值两种情况。故得出结论
         * 所有节点中，如果存在第二小的值，那一定是去左右孩子中和当前节点值相同的孩子继续向下dfs找到有可能比当前节点大
         * 但不大于其他节点的值作为返回结果，思考一个问题，为什么不去另一个比当前节点大的孩子的节点dfs下去呢，因为按题
         * 目规定，如果从更大节点子孩子继续dfs下去的节点值一定都是不小于该孩子节点的，只可能越找越大，这个更大的节点孩
         * 子就已经以他为根向下所有节点中的最小值了，我们直接拿着和另一个比他更小的兄弟节点dfs找到的值比较取二者更小即         * 可。
         * 转换成值域范围去想象一下在数轴上，假设当前根节点的右孩子val和根节点的val(min)相等，那从该点向下dfs的值域范         * 围就是[root.right.val, +∞)  = [min, +∞)
         * 那当前根节点的左孩子向下dfs值域范围就是[root.left.val, +∞), 而root.left.val > root.rigth.val
         * 两个节点向下dfs值域范围放在同一个数轴上就像下面这个情况:
         *                                 min
         *                                 root.right.val
         *                                 👇               root.left.val
         *                                                  👇
         * -∞---------------------------0------------------------------+∞>
         * 如果从root.left.val开始dfs就会错过一个盲区[root.right.val, root.left.val]这一段相交的区域内可能存在可以
         * 取得节点值。
         * 最后返回比较结果有下面三种情况:
         * 1.左孩子dfs下去且右孩子dfs下去找的值都比根节点(min)大 这里我们用 != -1 表示(也就是存在第二小的值)
         * 这时我们就取两者中的最小值返回为上一层的结果
         * 2.只有左孩子dfs下去的值比根节点(min)大， != -1，那就返回这个值(此时说明右孩子的值只剩下和根节点相等了)
         * 3.否则就是只有右孩子dfs下去的值比根节点(min)大，!= -1,那就返回右孩子找到的值(此时说明左孩子的值只剩下和根节      * 点相等了)
         */
        if(root == null) return -1;
        if(root.left == null && root.right == null) return -1;
        int leftVal = root.left.val;
        int rightVal = root.right.val;
        if(leftVal == root.val) leftVal = findSecondMinimumValue(root.left);
        if(rightVal == root.val) rightVal = findSecondMinimumValue(root.right);
        if(leftVal != -1 && rightVal != -1) return Math.min(leftVal, rightVal);
        if(leftVal != -1) return leftVal;
        return rightVal;
    }

}
