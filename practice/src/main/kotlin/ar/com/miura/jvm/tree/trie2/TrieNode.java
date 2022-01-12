package ar.com.miura.jvm.tree.trie2;

public class TrieNode {
    private static final int MAX_SIZE = 26;
    boolean isWord = false;
    TrieNode[] nodes = new TrieNode[MAX_SIZE];

    public boolean contains(char aChar) {
        int index = aChar - 'a';
        return nodes[index]!=null;
    }

    public TrieNode get(char aChar) {
        int index = aChar - 'a';
        return nodes[index];
    }

    public void put(char currentChar, TrieNode node) {
        int index = currentChar - 'a';
        nodes[index] = node;
    }
}
