package ar.com.miura.kotlin.extension

fun main(args:Array<String>) {
    val sample = "sample"
    println(sample.firstChar())
}

/**
 * Added an extension to class
 */
fun String.firstChar(): String = this.substring(1).toUpperCase()

class Extension {

}