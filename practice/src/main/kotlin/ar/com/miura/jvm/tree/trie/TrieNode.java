package ar.com.miura.jvm.tree.trie;

class TrieNode {

    private static final int MAX_SIZE = 26;

    private TrieNode[] links;

    private boolean isEnd = false;

    public TrieNode() {
        links = new TrieNode[MAX_SIZE];
    }

    public boolean containsKey(char c) {
        int index = c - 'a';
        return links[index]!=null;
    }

    public TrieNode get(char c) {
        int index = c - 'a';
        return links[index];
    }

    public void put(char c, TrieNode node) {
        int index = c - 'a';
        links[index] = node;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }

}
