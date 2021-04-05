package ar.com.miura.kotlin.loop

fun main(args:Array<String>) {

    val num = if (10>20) {
        println("hello")
        50
    } else {
        println("Hello2")
        51
    }

    //Using if as an expression inside a code sentence like a value
    println(" Num : $num ")

    when(10) {
        1 -> print(" First")
        2 -> print(" Second ")
        4,5,6 -> print("other")
        in 7..10 ->println(" In ranges ")
        else -> {
            print(" Another ")
        }
    }

}