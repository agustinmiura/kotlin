package ar.com.miura.kotlin

import org.junit.jupiter.api.Test
import java.util.*

class RandomTestcase {

    @Test
    fun `should fail random`() {

        var random = Random()
        for(i in 0..1000000) {
            var max = 10
            var index = (0..max).random()
            assert(index<10)
        }

    }

}