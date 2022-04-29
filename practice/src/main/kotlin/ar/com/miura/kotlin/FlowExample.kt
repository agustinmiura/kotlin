package ar.com.miura.kotlin

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

class FlowExample {

    fun startFlow() {
        runBlocking {
            getFlow().collect {
                value -> println(" I see the value : $value ")
            }

        }
    }

    suspend fun getFlow():Flow<String> {
        val flow: Flow<String> = flow {
            val types = listOf<String>("ONE", "TWO", "THREE", "FOUR")
            types.map{ element ->
                emit(element)
            }
        }
        return flow;
    }


}