package ar.com.miura.jvm.graph;

/**
 * https://leetcode.com/problems/synonymous-sentences/
 *
 * You are given a list of equivalent string pairs synonyms where synonyms[i] = [si, ti] indicates that si and ti are equivalent strings. You are also given a sentence text.
 *
 * Return all possible synonymous sentences sorted lexicographically.
 *
 *
 *
 * Example 1:
 *
 * Input:
 * synonyms = [["happy","joy"],["sad","sorrow"],["joy","cheerful"]],
 * text = "I am happy today but was sad yesterday"
 * Output:
 * ["I am cheerful today but was sad yesterday",
 * "I am cheerful today but was sorrow yesterday",
 * "I am happy today but was sad yesterday",
 * "I am happy today but was sorrow yesterday",
 * "I am joy today but was sad yesterday",
 * "I am joy today but was sorrow yesterday"]
 * Example 2:
 *
 * Input: synonyms = [["happy","joy"],["cheerful","glad"]], text = "I am happy today but was sad yesterday"
 * Output: ["I am happy today but was sad yesterday","I am joy today but was sad yesterday"]
 * Example 3:
 *
 * Input: synonyms = [["a","b"],["c","d"],["e","f"]], text = "a c e"
 * Output: ["a c e","a c f","a d e","a d f","b c e","b c f","b d e","b d f"]
 * Example 4:
 *
 * Input: synonyms = [["a","QrbCl"]], text = "d QrbCl ya ya NjZQ"
 * Output: ["d QrbCl ya ya NjZQ","d a ya ya NjZQ"]
 */
public class SynonimousSentences {
    public java.util.List<String> generateSentences(java.util.List<java.util.List<String>> synonyms, String text) {

        /*
        create a graph
        */
        java.util.Map<String, java.util.List<String>> graph = new java.util.TreeMap<String, java.util.List<String>>();
        for(java.util.List<String> strings:synonyms) {

            String first = strings.get(0);
            String second = strings.get(1);

            java.util.List<String> adjacent = graph.getOrDefault(first, new java.util.ArrayList<String>());
            adjacent.add(second);
            graph.put(first, adjacent);

            adjacent = graph.getOrDefault(second, new java.util.ArrayList<String>());
            adjacent.add(first);
            graph.put(second, adjacent);

        }

        java.util.List<String> combinations = new java.util.ArrayList<String>();

        java.util.Set<String> visited = new java.util.HashSet<String>();
        java.util.Queue<String> queue = new java.util.LinkedList<String>();
        queue.add(text);

        while(!queue.isEmpty()) {

            String word = queue.poll();
            visited.add(word);

            String[] splitted = word.split(" ");
            for(int i =0;i<splitted.length;i++) {
                String key = splitted[i];
                java.util.List<String> adjacents = graph.getOrDefault(key, new java.util.ArrayList<String>());
                if (adjacents.size()>=1) {
                    for(String adjacent:adjacents) {
                        splitted[i]=adjacent;
                        String newText = String.join(" ", splitted);
                        if (!visited.contains(newText)) {
                            queue.add(newText);
                        }
                    }
                }
            }




        }

        java.util.List<String> list = new java.util.ArrayList<>(visited);
        java.util.Collections.sort(list);
        return list;
    }
}
