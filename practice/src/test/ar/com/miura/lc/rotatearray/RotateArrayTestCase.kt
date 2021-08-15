package ar.com.miura.lc.rotatearray

import ar.com.miura.lc.array.RotateArray
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RotateArrayTestCase {

    @Test
    fun `should find in normal array`() {
        var nums = intArrayOf(0,1,2,3,5,6,7)
        assertEquals(0, RotateArray().search(nums, 0))
    }

    @Test
    fun `should find in rotatedArray 1`() {
        var nums = intArrayOf(4,5,6,7,0,1,2)
        assertEquals(4, RotateArray().search(nums, 0))
    }

    @Test
    fun `should find in rotatedArray`() {
        var nums = intArrayOf(7,0,1,2,3,5,6,)
        assertEquals(1, RotateArray().search(nums, 0))
    }


}