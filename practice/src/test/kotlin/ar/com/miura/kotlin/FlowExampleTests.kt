package ar.com.miura.kotlin

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class FlowExampleTests {

    @Test
    fun `should run the example`() {
        runBlocking {
            val flow = FlowExample()
            flow.startFlow()
        }
    }
}