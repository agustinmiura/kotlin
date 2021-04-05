package ar.com.miura.kotlin.`object`

fun main(args: Array<String>) {
    MySingleton.getYear()
}


object MySingleton {
    fun getYear() = "2021"
}