package ar.com.miura.kotlin.loop

import java.lang.NumberFormatException

fun main(args: Array<String>) {
    println("Get Number ${getNumber("hola")}")
}

/**
 * As an expression because the last value in try or catch is retured.
 */
fun getNumber(value:String):Int {
    return try {
            Integer.parseInt(value)
        }catch(e:NumberFormatException) {
            0
        }

}