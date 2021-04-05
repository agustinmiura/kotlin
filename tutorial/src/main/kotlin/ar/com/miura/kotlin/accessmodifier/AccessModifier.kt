package ar.com.miura.kotlin.accessmodifier

fun main(args: Array<String>) {
    var sample = PrivateClass()
    var sampleClass = SampleClass("firstName")
    var sampleClass2 = SampleClass("firstName", true)
    println(sampleClass.fullTime)
}

/**
 * Visible for everyone in the same file
 */
private class PrivateClass {

}

/**
 *  Java class with primary constructor
 */
class SampleClass(firstName: String) {

    /**
     * This property must be initialized
     * because secundary constructors don't do it .
     */
    var fullTime:Boolean = false

    init {

    }

    constructor(firstName:String,fullTime:Boolean): this(firstName) {
        this.fullTime = fullTime
    }

}