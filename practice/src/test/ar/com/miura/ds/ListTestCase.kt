package ar.com.miura.ds

import java.util.*

fun main() {

    var maxSize = 0
    var chars = mutableSetOf<Char>()
    chars.size
    chars.clear()

    var aList = mutableListOf<List<String>>()

    var aMap = mutableMapOf<String,String>("1" to "2")
    for((k,v) in aMap) {
        println("k : $k ")

    }


    val word = "Word"
    val charArray = word.toCharArray()
    charArray.sort()
    val string = String(charArray)

    var numArray = intArrayOf(10,9,8,7,6,5)

    numArray.size

    var sorted = numArray.sortedArray()

    println("Sorted : ${sorted} ")
    for((k,v) in sorted.withIndex()) {
        println(" value ${v} ")
    }

    var list = listOf<Int>(12,12,13)

    Collections.sort(list)

    val matrix: Array<IntArray> = arrayOf<IntArray>(intArrayOf(1,2,3), intArrayOf(2,4,5), intArrayOf(7,8,9))
    print("${matrix.size}")
}

class ListTestCase {
}