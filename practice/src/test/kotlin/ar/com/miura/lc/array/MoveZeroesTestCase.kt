package ar.com.miura.lc.array
import org.junit.jupiter.api.Test
class MoveZeroesTestCase {
    @Test
    fun `should move the zeroes`() {
        var numbers = intArrayOf(0,1,0,3,12)
        MoveZeroes().moveZeroes(numbers)
    }
}