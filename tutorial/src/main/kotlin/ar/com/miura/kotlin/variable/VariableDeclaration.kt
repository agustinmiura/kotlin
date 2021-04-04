package ar.com.miura.kotlin.variable

import ar.com.miura.kotlin.interoperability.KotlinCar

fun main(args: Array<String>) {

    /**
     * El compilador debe conocer el tipo
     * de la variable
     */
    val number = 25
    //This is not common
    val number2 : Int = 26

    //we need to notify the compiler that we need a short the default
    //is int
    val short: Short = 25
    //This would fail
    //short = 10lue

    /**
     * We can change and assign
     * the variables
     */
    var aNumber = 10
    aNumber = 20

    /**
     * We don't use new to create new objects calling
     * the constructor
     */
    var kotlinCar = KotlinCar("Blue", "Ford", 25)
    //
    //kotlinCar = ""

}