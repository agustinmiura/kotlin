package ar.com.miura.kotlin

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class ParallelExampleTests {

    @Test
    fun `should run the example`() {
        runBlocking {
            val example = ParallelExample()
            example.execute()
        }
    }
}