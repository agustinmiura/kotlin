package ar.com.miura.pramp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PairsTestCase {

    @Test
    public void shouldFindPairs() {
        int[] numbers = new int[]{0, -1, -2, 2, 1};
        int k = 1;
        int[][] solution = ar.com.miura.pramp.PairsWithSpecificDifference.findPairsWithGivenDifference(numbers, k);
        assertEquals(4, solution.length);
    }

}
