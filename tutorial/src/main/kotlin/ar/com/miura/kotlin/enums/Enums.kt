package ar.com.miura.kotlin.enums

fun main(args:Array<String>) {
    println(Department.NORTH.description)
    println(Department.NORTH.sample())
}

enum class Department(val description:String) {
    NORTH("North"), SOUTH("South"), EAST("East"), WEST("West");

    fun sample():String {
        return "sample"
    }

}