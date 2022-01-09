package ar.com.miura.jvm.string;


/**
 * https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/591/week-4-march-22nd-march-28th/3681/
 */
public class Dewovel {

    public String[] spellchecker(String[] wordlist, String[] queries) {

        java.util.Set<String> exact = new java.util.HashSet<>();
        java.util.Map<String, String> caseInsensitive = new java.util.HashMap<>();
        java.util.Map<String, String> consonant = new java.util.HashMap<>();

        for(String eachWord:wordlist) {

            exact.add(eachWord);

            caseInsensitive.putIfAbsent(eachWord.toLowerCase(), eachWord);
            consonant.putIfAbsent(deVowel(eachWord.toLowerCase()), eachWord);

        }


        String[] results = new String[queries.length];
        int i=-1;
        for(String query:queries) {
            i++;
            if (exact.contains(query)) {
                results[i] = query;

            } else if (caseInsensitive.containsKey(query.toLowerCase())) {
                results[i] = caseInsensitive.get(query.toLowerCase());

            } else if (consonant.containsKey(deVowel(query.toLowerCase()))) {
                results[i] = consonant.get(deVowel(query.toLowerCase()));

            } else {
                results[i] = "";
            }
        }
        return results;

    }

    public String deVowel(String word) {

        StringBuilder sBuilder = new StringBuilder();

        for(char c:word.toCharArray()) {

            sBuilder.append( isVowel(c) ? "*" : c);

        }
        return sBuilder.toString();

    }

    public boolean isVowel(char c) {
        return (c=='a'||c=='e'||c=='i'||c=='o'||c=='u');
    }
}
