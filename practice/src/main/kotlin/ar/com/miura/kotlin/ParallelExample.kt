package ar.com.miura.kotlin

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll

class ParallelExample {

    suspend fun execute() {
        var elements = listOf("ONE", "TWO", "THREE", "FOUR")
        elements.map {
            CoroutineScope(Dispatchers.Default).async {
                inParallel();
            }
        }.awaitAll()
    }

    private suspend fun inParallel() {
        println(" I see the task ")
    }

}