package part_1.easy.backtracking;

import sun.reflect.generics.tree.Tree;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePaths257 {

    private static int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    private static List<TreeNode> nodeList = null;

    /**
     * 内部类：节点
     *
     * @author ocaicai@yeah.net @date: 2011-5-17
     *
     */
//    private static class TreeNode {
//        Node leftChild;
//        Node rightChild;
//        int data;
//
//        Node(int newData) {
//            leftChild = null;
//            rightChild = null;
//            data = newData;
//        }
//    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void createBinTree() {
        nodeList = new LinkedList<TreeNode>();
        // 将一个数组的值依次转换为Node节点
        for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++) {
            nodeList.add(new TreeNode(array[nodeIndex]));
        }
        // 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树
        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
            // 左孩子
            nodeList.get(parentIndex).left = nodeList
                    .get(parentIndex * 2 + 1);
            // 右孩子
            nodeList.get(parentIndex).right = nodeList
                    .get(parentIndex * 2 + 2);
        }
        // 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理
        int lastParentIndex = array.length / 2 - 1;
        // 左孩子
        nodeList.get(lastParentIndex).left = nodeList
                .get(lastParentIndex * 2 + 1);
        // 右孩子,如果数组的长度为奇数才建立右孩子
        if (array.length % 2 == 1) {
            nodeList.get(lastParentIndex).right = nodeList
                    .get(lastParentIndex * 2 + 2);
        }
    }

    public static void main(String[] args) {
        createBinTree();
        List<String> Paths = binaryTreePaths(nodeList.get(0));
        System.out.println(Paths);
    }



    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if(root == null) {
            return paths;
        }
        List<Integer> values = new ArrayList<>();
        backTracking(root, values, paths);
        return paths;
    }

    private static void backTracking(TreeNode node, List<Integer> values, List<String> paths) {
        if(node == null) {
            return;
        }
        values.add(node.val);
        if(isLeaf(node)) {
            paths.add(buildPath(values));
        } else {
            backTracking(node.left, values, paths);
            backTracking(node.right, values, paths);
        }
        values.remove(values.size() - 1);
    }

    private static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private static String buildPath(List<Integer> values) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < values.size(); ++i) {
            sb.append(values.get(i));
            if(i != values.size() - 1) {
                sb.append("->");
            }
        }
        return sb.toString();
    }
}
