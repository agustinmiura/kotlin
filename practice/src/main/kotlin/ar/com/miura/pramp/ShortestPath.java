package ar.com.miura.pramp;
import java.util.*;

public class ShortestPath {
    /**
     * @param source
     * @param target
     * @param words
     * @return
     */
    static int shortestWordEditPath(String source, String target, String[] words) {
        Queue<String> queue = new LinkedList<String>();
        queue.add(source);

        Set<String> visited = new HashSet<String>();

        List<String> children = new ArrayList<String>();

        int level = -1;
        while(!queue.isEmpty()) {
            children.clear();
            level++;
            int size = queue.size();
            for(int i=0;i<size;i++) {
                String node = queue.poll();
                if (node.equals(target)) {
                    return level;
                }
                List<String> strings = getAdjacentNodes(node, words);
                for(String string:strings) {
                    if (!visited.contains(string)) {
                        queue.add(string);
                    }
                }
            }
        }
        return -1;
    }

    /**
     * @param node
     * @param words
     * @return
     */
    static List<String> getAdjacentNodes(String node, String[] words) {
        List<String> adjacents = new ArrayList<String>();
        for(String word:words) {
            if (word.equals(node)) {
                continue;
            }
            int diff = getDiff(node, word);
            if (diff==1) {
                adjacents.add(word);
            }
        }
        return adjacents;
    }

    static int getDiff(String word0, String word1) {

        int diff = 0;
        int size = word0.length();
        for(int i=0;i<size;i++) {
            if (word0.charAt(i)!=word1.charAt(i)) {
                diff++;
            }
        }
        return diff;
    }
}