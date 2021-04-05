package ar.com.miura.kotlin.generics

fun main(args: Array<String>) {

    val strings = listOf("one", "two", "three", "four")

    /**
     * For big collections
     * Not evaluated
     */
    val value = strings.asSequence().filter { it.length >= 2 }
    println(" The value is $value ")

    /**
     * Not lazy
     */
    val result = strings.map { it.toUpperCase() }.filter { it.length >=2 }.toList()
    println(" The value is : $result ")

}