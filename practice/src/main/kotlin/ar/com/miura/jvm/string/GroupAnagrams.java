package ar.com.miura.jvm.string;

public class GroupAnagrams {
    public java.util.List<java.util.List<String>> groupAnagrams(String[] strs) {

        java.util.Map<String, java.util.List<String>> map = new java.util.HashMap<>();

        for(String string:strs) {
            char[] chars = string.toCharArray();
            java.util.Arrays.sort(chars);
            String key = new String(chars);

            java.util.List<String> words = map.getOrDefault(key, new java.util.ArrayList<String>());
            words.add(string);
            map.put(key, words);
        }

        java.util.List<java.util.List<String>> words = new java.util.ArrayList<>();

        for(java.util.Map.Entry<String, java.util.List<String>> entry:map.entrySet()) {
            java.util.List<String> list = entry.getValue();
            words.add(list);
        }

        return words;

    }
}
