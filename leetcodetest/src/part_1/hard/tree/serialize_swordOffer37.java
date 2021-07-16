package part_1.hard.tree;

public class serialize_swordOffer37 {

    private String deserializeStr;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // 序列化 我这里采用空格分割，方便一会还原，如果递归到叶子节点之后或者为空我们用 “#” 做标识
        if(root == null) return "#";
        return root.val + " " + serialize(root.left) + " " + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // 把刚刚我们序列化的树字符串取出来
        deserializeStr = data;
        // 按照我们设置的分隔符递归还原树的结构
        return deserialize();
    }

    private TreeNode deserialize() {
        if(deserializeStr.length() == 0) return null;
        // 找到当前第一个节点的后一个位置
        int index = deserializeStr.indexOf(" ");
        // substring()方法左闭右开 刚好取到第一个节点
        String node = index == -1 ? deserializeStr : deserializeStr.substring(0, index);
        // 第一个节点已经取到，从当前deserializeStr中删除掉
        deserializeStr = index == -1 ? "" : deserializeStr.substring(index + 1);
        if(node.equals("#")) return null;
        int val = Integer.valueOf(node);
        TreeNode t = new TreeNode(val);
        t.left = deserialize();
        t.right = deserialize();
        return t;
    }

}
