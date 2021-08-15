package ar.com.miura.lc.getrandom

import ar.com.miura.lc.design.RandomizedSet
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class RandomizedTestCase {

    @Test
    fun `should work`() {

        var randomized = RandomizedSet()

        assertTrue(randomized.insert(1))
        assertFalse(randomized.remove(2))
        assertTrue(randomized.insert(2))
        randomized.getRandom()
        assertTrue(randomized.remove(1))
        assertFalse(randomized.insert(2))
        randomized.getRandom()

    }
}