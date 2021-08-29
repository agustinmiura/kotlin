package ar.com.miura.kotlin

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ArrayTestCase {

    @Test
    fun `should start arrays with zero`() {
        var anArray = IntArray(10)
        for (i in anArray) {
            assertEquals(0, i)
        }
    }

    @Test
    fun `should initialize with -1`() {
        var anArray = IntArray(10, { -1 })
        for (i in anArray) {
            assertEquals(-1, i)
        }
    }

}