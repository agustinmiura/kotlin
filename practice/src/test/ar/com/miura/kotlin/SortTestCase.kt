package ar.com.miura.kotlin

import org.junit.jupiter.api.Test

class SortTestCase {

    @Test
    fun `should sort collections`() {
        var meetings = mutableListOf<IntArray>(intArrayOf(1,1), intArrayOf(0,0));
        meetings.sortWith({ x ,y -> (x[1]-y[1])});
        for(pair in meetings) {
            println("pair : ${pair[0]}, ${pair[1]}")
        }
    }

}