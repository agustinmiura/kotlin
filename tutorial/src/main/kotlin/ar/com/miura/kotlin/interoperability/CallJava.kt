package ar.com.miura.kotlin.interoperability

import ar.com.miura.java.interoperbility.Car

fun main(args: Array<String>) {

    /**
     * Calling object java from Kotlin without a problem
     * The Kotlin compiler compiles the Java compiler and needs to
     * know if they can assign it to a nullable or non nullable type
     *
     * @NotNull an Intellij Annotation
     * Nothing enforces it
     */
    val car = Car("blue", "Ford", 2015)
    car.color = "green"
    println(car)

    /**
     * This may fail here fails
     * with the annotation at runtime that
     * is checked
     */
    //car.color = null
    //println(car)

    /**
     * With @Nullable we are allowing to set the null value
     * during runtime
     */
    //car.model = null
    println(car)
    println(car.model.javaClass)

    val modelString: String = car.model
    //we can't do this because model is not nullable
    //modelString = null

    /**
     * When the compiler doesn't have a hint
     * uses a platform type that can be used
     * as nullable or nullabe
     * So can be String or a String?
     * The ! are plaform types
     * When using platofrm types it is our
     * responsability to check the null types
     */
    car.color = "Blue"
    val color: String = car.color
    if (color!=null) {
        println(color)
    }

    /**
     * The . operation calls from behind
     * the setters and getters
     */
    car.color

    /**
     * Calling a vararg method
     */
    car.varArgsMethod( "hello", "hello2")

    var strings = arrayOf("hello", "hello2")
    /**
     * This won't work
     */
    //car.varArgsMethod(strings)

    /**
     * Call it with this
     * With the spread operator
     */
    car.varArgsMethod(*strings)

    /**
     * Calling a method that uses an
     * int array
     */
    car.usesIntArray(intArrayOf(1,2,3,4,5))

    /**
     * For java Object , Any .
     * Same behaviour
     * Cast the object to java.lang.Object for those methods
     * if you need more than hashcode, toString
     */
    car.anObject = "Hello"
    //(car.anObject as java.lang.Object).notify()

    /***
     * Static field and methods they are converted
     * to companion objects
     */
    println(" x = ${Car.x} ")
    println(Car.xString())
}