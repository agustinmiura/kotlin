package ar.com.miura.kotlin.inheritance

fun main(args: Array<String>) {

}

open class Something:ChildInterface {

    override var number:Int = 25

    override fun mySubFunction(str: String): String {
        return "hello"
    }

    override fun myFunction(str: String): String {
        return "hello2"
    }

}

abstract class Printer(var modelName:String) {
    open fun printModel() = println(" Print ")
    abstract fun bestSellingPrice():Double

}

class Laser(modelName: String):Printer(modelName) {
    final override fun printModel() = println(" The printer $modelName ")
    override fun bestSellingPrice(): Double {
        return 20.0
    }
}

interface MyInterface {
    val number: Int
    fun myFunction(str: String):String
}

interface ChildInterface:MyInterface {
    fun mySubFunction(str: String):String
}