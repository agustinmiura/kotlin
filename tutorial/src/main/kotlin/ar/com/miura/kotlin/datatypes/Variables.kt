package ar.com.miura.kotlin.datatypes

fun main(args: Array<String>) {

    val numberInt = 10
    val double = 22.20

    val short:Short = 22
    var long:Long = 22
    val float: Float = 22.0f

    //This fails
    //long = short
    long = short.toLong()

    println(double is Double)

}