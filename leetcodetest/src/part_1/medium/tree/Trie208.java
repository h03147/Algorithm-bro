package part_1.medium.tree;

public class Trie208 {

    private Trie208[] children;
    private boolean isEnd;


    /** Initialize your data structure here. */
    public Trie208() {
        // Trie前缀树(或者叫多叉单词查找数，字典树)

        // 每个节点开辟26个存储空间，因为最多的情况下有a-z，26个英文字母在当前树中都构成了可能的前缀字母
        children = new Trie208[26];
        // 初始化单词结尾标示为false
        isEnd = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        // node指针指向当前对象的头结点
        Trie208 node = this;
        for(int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if(node.children[index] == null) {
                node.children[index] = new Trie208();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        // 调用前缀树遍历方法如果整个word遍历完了node还没指向空，并且正好指向一个isEnd标示为true说明当前单词存在
        // 于前缀树中
        Trie208 node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        // 调用前缀树遍历方法把prefix前缀单词装进去，如果最后返回的不是空指针说明前缀存在
        return searchPrefix(prefix) != null;
    }

    // 查找单词是否存在于前缀树中遍历方法的封装
    public Trie208 searchPrefix(String prefix) {
        Trie208 node = this;
        for(int i = 0; i < prefix.length(); ++i) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if(node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }

}
