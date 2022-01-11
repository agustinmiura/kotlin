package ar.com.miura.jvm.tree.trie;

class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {

        TrieNode node = root;
        char[] chars = word.toCharArray();
        for(char aChar:chars) {

            if (node.containsKey(aChar)) {
                node = node.get(aChar);

            } else {
                node.put(aChar, new TrieNode());
                node = node.get(aChar);

            }

        }
        node.setEnd();

    }

    public boolean search(String word) {

        char[] chars = word.toCharArray();
        TrieNode node = root;
        for(char aChar:chars) {
            if (node.containsKey(aChar)) {
                node = node.get(aChar);
            } else {
                node = null;
                break;
            }
        }
        return (node!=null && node.isEnd());

    }

    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        TrieNode node = root;
        for(char aChar:chars) {
            if (node.containsKey(aChar)) {
                node = node.get(aChar);
            } else {
                node = null;
                break;
            }
        }
        return (node!=null);
    }
}
