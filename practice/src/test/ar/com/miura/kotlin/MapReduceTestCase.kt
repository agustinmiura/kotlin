package ar.com.miura.kotlin

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class MapReduceTestCase {

    @Test
    fun `should find map and reduce`() {
        //var graph = mutableMapOf<Int, MutableListOf<Int>>()

        var numbers = mutableListOf<Int>(1, 2, 3, 4)
        var result = numbers.map { it * it }.reduce { y, vars -> y + vars }
        numbers.sort()
        assertEquals(30, result)

    }

    @Test
    fun `should find map `() {
        var numbers = mutableListOf<Int>(1, 2, 3, 4)
        var result: MutableList<Int> = numbers.map { it * it } as MutableList<Int>
        assertNotNull(result)
    }

}