package part_1.medium.tree;

public class MapSum677 {

    // 定义节点结构
    private class Node {
        Node[] children = new Node[26];
        int val;
    }

    Node root;

    /*
     * 分析题意：本题用前缀树求解会很方便，考虑前缀树结构，每次插入操作都把key在前缀树中建立子节点在key字符串结尾的时候
     * 把val存到对应节点中，然后在求前缀和的时候先判断前缀字符串是否存在如果存在就从前缀节点的末尾节点开始进行dfs，找其
     * 下面的全部可能不为0的节点值加起来(也就是把这个前缀开始的向下延生的全部单词对应的val加起来了)。
     */
    /** Initialize your data structure here. */
    public MapSum677() {
        root = new Node();
    }

    public void insert(String key, int val) {
        Node node = root;
        for(int i = 0; i < key.length(); ++i) {
            int index = key.charAt(i) - 'a';
            if(node.children[index] == null) node.children[index] = new Node();
            node = node.children[index];
        }
        node.val = val;
    }

    public int sum(String prefix) {
        Node node = root;
        for(int i = 0; i < prefix.length(); ++i) {
            int index = prefix.charAt(i) - 'a';
            if(node.children[index] == null) return 0;
            node = node.children[index];
        }
        return dfs(node);
    }

    private int dfs(Node node) {
        if(node == null) return 0;
        int answer = 0;
        for(int i = 0; i < 26; ++i) {
            if(node.children[i] != null) answer += dfs(node.children[i]);
        }
        return answer + node.val;
    }

}
