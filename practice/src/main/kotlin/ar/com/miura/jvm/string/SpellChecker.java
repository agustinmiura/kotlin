package ar.com.miura.jvm.string;

public class SpellChecker {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        java.util.Set<String> perfect = new java.util.HashSet<String>();
        java.util.Map<String, String> lowers = new java.util.HashMap<>();
        java.util.Map<String, String> devowels = new java.util.HashMap<>();

        for(String string:wordlist) {

            perfect.add(string);

            String lowerCase = string.toLowerCase();
            lowers.putIfAbsent(lowerCase, string);

            String devowel = devowel(lowerCase);
            devowels.putIfAbsent(devowel, string);

        }

        String[] words = new String[queries.length];
        for(int i=0;i<queries.length;i++) {
            words[i] = solve(queries[i], perfect, lowers, devowels);
        }
        return words;

    }

    private String solve(String query, java.util.Set<String> perfects, java.util.Map<String, String> lowers, java.util.Map<String, String> devowels) {

        String solved = "";
        String lowercase = query.toLowerCase();
        if (perfects.contains(query)) {
            solved = query;

        } else if (lowers.containsKey(lowercase)) {
            solved = lowers.get(lowercase);

        } else if (devowels.containsKey(devowel(lowercase))) {
            solved = devowels.get(devowel(lowercase));

        } else {
            solved = "";
        }
        return solved;

    }

    private String devowel(String string) {
        java.util.Set<Character> vowels = new java.util.TreeSet<Character>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        char[] chars = string.toCharArray();
        int size = string.length();
        for(int i=0;i<size;i++) {

            char aChar = chars[i];
            if (aChar=='a'||aChar=='e'||aChar=='i'||aChar=='o'||aChar=='u') {
                chars[i] = '*';
            } else {
                chars[i] = aChar;
            }
        }
        return new String(chars);
    }
}
