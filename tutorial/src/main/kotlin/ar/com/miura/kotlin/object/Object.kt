package ar.com.miura.kotlin.`object`

fun main(args: Array<String>) {
    MySingleton.getYear()
    println(SomeClass.staticField)
}

object MySingleton {
    fun getYear() = "2021"
}

class SomeClass {
    companion object {
        val staticField = 42
    }

}