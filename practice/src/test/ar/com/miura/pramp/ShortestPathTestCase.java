package ar.com.miura.pramp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShortestPathTestCase {

    @Test
    public void shouldFindPath() {

        String source = "bit";
        String target = "dog";
        String[] words = new String[]{"but", "put", "big", "pot", "pog", "dog", "lot"};

        int size = ShortestPath.shortestWordEditPath(source, target, words);
        assertEquals(5, size);

    }

}
