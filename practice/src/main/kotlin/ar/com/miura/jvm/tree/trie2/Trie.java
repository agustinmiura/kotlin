package ar.com.miura.jvm.tree.trie2;

public class Trie {

    TrieNode root = new TrieNode();

    void insert(String string) {
        TrieNode node = root;
        char[] chars = string.toCharArray();
        int size = chars.length;
        for(int i=0;i<size;i++) {

            char currentChar = chars[i];

            if (node.contains(currentChar)) {
                node = node.get(currentChar);
            } else {
                node.put(currentChar, new TrieNode());
                node = node.get(currentChar);
            }
        }
        node.isWord = true;
    }

    java.util.List<String> getWordsWithPrefix(String prefix) {

        java.util.List<String> results = new java.util.ArrayList<String>();

        char[] chars = prefix.toCharArray();
        TrieNode node = root;
        /*
        Look for the prefix
        */
        for(int i=0;i<chars.length;i++) {
            if (node.contains(chars[i])) {
                node = node.get(chars[i]);

            } else {
                return results;

            }
        }

        /**
         * From the prefix do a dfs search
         **/
        dfs(node, prefix, results);
        return results;

    }

    private void dfs(TrieNode node, String prefix, java.util.List<String> results) {

        if (results.size()==3) {
            return;
        }

        if (node.isWord) {
            results.add(prefix);
        }

        for(char c='a'; c<='z' ; c++) {
            if (node.contains(c)) {
                dfs(node.get(c), prefix + c, results);
            }
        }

    }

}
