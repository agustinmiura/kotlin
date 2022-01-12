package ar.com.miura.jvm.tree.trie2;

public class SuggestedProducts {
    public java.util.List<java.util.List<String>> suggestedProducts(String[] products, String searchWord) {

        Trie trie = new Trie();

        java.util.List<java.util.List<String>> words = new java.util.ArrayList<>();

        for(String word:products) {
            trie.insert(word);
        }

        char[] chars = searchWord.toCharArray();
        StringBuilder sBuilder = new StringBuilder();
        for(char c:searchWord.toCharArray()) {
            sBuilder.append(c);
            words.add(trie.getWordsWithPrefix(sBuilder.toString()));
        }
        return words;

    }
}
