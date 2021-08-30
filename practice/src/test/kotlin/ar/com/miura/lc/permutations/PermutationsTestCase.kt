package ar.com.miura.lc.permutations

import ar.com.miura.lc.backtracking.Permutations
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class PermutationsTestCase {
    @Test
    fun `should get permutations`() {
        var array = mutableListOf<Int>(1,2,3);
        var permutations = Permutations().getPermutations(array);
        assertEquals(6, permutations.size)
    }

}