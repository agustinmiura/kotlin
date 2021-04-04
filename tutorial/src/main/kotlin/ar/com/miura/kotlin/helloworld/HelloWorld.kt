package ar.com.miura.kotlin.helloworld

fun main(args: Array<String>) {

    println("Hello world")

    val names = arrayListOf("John", "Jane", "Mary")
    val aName = names[0]

    /**
     * Here the alternative for the ternary
     */
    val newName = names ?: "alternative"

    for(name in names) {

    }

}