package ar.com.miura.kotlin.lambda

import ar.com.miura.kotlin.equality.Employee

fun main(args: Array<String>) {

    run { println(" I am a lambda ") }
    val collections = listOf<String>("String1", "String2", "String3")

    val employees = listOf(
        Employee("color1", "brand1", 1),
        Employee("color2", "brand2", 2),
        Employee("color3", "brand3", 3),
        Employee("color4", "brand4", 4),
    )

    /**
     * With collections
     */
    println(employees.minBy { e -> e.age} )

    /**
     * Lists
     */
    var inmutableList = listOf<String>("A", "B", "C")
    var mutableList = mutableListOf("A", "B", "C")

    /**
     * Getting elements
     */
    println(inmutableList[0])

    /**
     * Adding elements
     */
    println(mutableList.add("10"))
    println(mutableList)

    /**
     * Check if contains element
     */
    println(mutableList.contains("element"))

    /**
     * Filter elements
     */
    println(mutableList.filter { it.startsWith("Z")})

    /**
     * Operations for maps
     */
    val stringMap = mapOf(
        1 to "one",
        2 to "two",
        3 to "three"
    )
    println(stringMap)
    /**
     * Get size
     */
    println(stringMap.size)

    /**
     * Getting entries , keys and values
     */
    println(stringMap.entries)
    println(stringMap.keys)
    println(stringMap.values)

    /**
     * Mutable map
     */
    val mutableMap = mutableMapOf(
        1 to "one",
        2 to "two",
        3 to "three"
    )
    mutableMap.put(33, "33")
    println(mutableMap)

    /**
     * For each iteration
     */
    mutableMap.forEach{ (k,v) -> println(" key $k, , value $v ") }

    /**
     * Sets in Kotlin
     */
    val setInmutable = setOf("one", "two", "three", "four")
    val mutable = mutableSetOf("one", "two")

    val len = setInmutable.count()
    val max = setInmutable.maxOrNull()
    val min = setInmutable.minOrNull()
    println(" Len set : $len ")
    println(" Max set : $max ")
    println(" Min Set : $min ")

    /**
     * Access an index element
     */
    println(" Set : ${setInmutable.elementAt(0)}")
    /**
     * Get the last element
     */
    println(" Last : ${setInmutable.last()}")
    /**
     * Iteration
     */
    for(eachElemen in setInmutable) {
        println("Element in : $eachElemen ")
    }
    /**
     * Adding element
     */
    println(mutable.add("11"))
    println(" After add : $mutable ")

    /**
     * Union get distinct elemnets
     */
    val nums = setOf(1, 2, 3)
    val nums2 = setOf(3, 4, 5,4,4)
    println(nums.union(nums2))


}