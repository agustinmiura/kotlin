package ar.com.miura.kotlin.interoperability

import java.io.IOException

fun main(args: Array<String>) {

}

class KotlinCar(val color:String, val model:String, val year:Int) {

    companion object {
        @JvmField val isAuto = false
        @JvmStatic fun carComp() = println(" Iam in cars companion object ")
    }

    fun printMe(text:String) {
        println(" I don't expect any value ")
    }

    @Throws(IOException::class)
    fun throwException() {
        throw IOException("Exception")
    }

    @JvmOverloads fun defaultArgs(
        str: String, num: Int = 25) {
    }

}

object Singleton {
    fun doSomething() = println(" I am doing something ")
}