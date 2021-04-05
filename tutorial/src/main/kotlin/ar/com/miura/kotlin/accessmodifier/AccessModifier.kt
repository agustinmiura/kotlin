package ar.com.miura.kotlin.accessmodifier

val MY_COSNTANT = 100

fun main(args: Array<String>) {
    var sample = PrivateClass()
    var sampleClass = SampleClass("firstName")
    var sampleClass2 = SampleClass("firstName", true)
    sampleClass2.fullTime = false
    sampleClass2.firstName = "sane"

    println(sampleClass.fullTime)
    println(MY_COSNTANT)

    val dataClass = SampleDataClass("Blue", "Ford")
    println(dataClass)
}

/**
 * Visible for everyone in the same file
 */
private class PrivateClass {

}

/**
 *  Java class with primary constructor
 */
class SampleClass(var firstName: String) {

    /**
     * This property must be initialized
     * because secundary constructors don't do it .
     */
    var fullTime:Boolean = false
    get() {
        return field;
    }
    set(value) {
        println("Custom set property")
    }

    /**
     * Can't be accesed from outside
     */
    private var privateAttribute: Boolean = true

    init {

    }

    constructor(firstName:String,fullTime:Boolean): this(firstName) {
        this.fullTime = fullTime
    }

}

data class SampleDataClass(var color:String, val model:String) {}