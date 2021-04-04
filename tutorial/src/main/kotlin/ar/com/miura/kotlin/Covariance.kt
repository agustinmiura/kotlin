package ar.com.miura.kotlin

import org.intellij.lang.annotations.Flow

/**
 * Covariance and upper variance
 */
fun main(args: Array<String>) {

    val shorts: List<Short> = listOf(1,2,3,4,5)
    convertToInt(shorts)

    val shortsMutable: MutableList<Short> = mutableListOf(1,2,3,4,5)
    convertToInt(shortsMutable)
    /*
    * Failed : convertToIntMutable(shorts)
    *        : convertToIntMutable(shortsMutable)
    * */

}

/**
 * Because Number implements the toInt we can do
 * this function
 */
fun convertToInt(collection: List<Number>) {
    for(number in collection) {
        println("${number.toInt()}")
    }
    // Problems that could happen with covariant classes
    // Declare a list with short and add decimals .
    //collection.add(25.3)
}

fun convertToIntMutable(collection: MutableList<Number>) {
    for(number in collection) {
        println("${number.toInt()}")
    }

}

/**
 * Covariance
 * List of short like a list of number
 * List of short must be a type of number the parameter must be a
 * covariant
 * Mutable isn't covariant
 * The subtype must be preserved .
 * With covariant the subtype is preserved
 * With mutable list the subtype is not preseverd
 * */

fun tendGarden(roseGarden: Garden<Rose>) {
    /**
     * This won't work because the compiler
     * won't recognize that the Rose is a
     * subtype of Flower.
     */
    //waterGarden(roseGarden)
}

/**
 * Water garden supports covariant
 */
fun waterGarden(garden: Garden<Flower>) {

}

open class Flower {

}

class Rose: Flower() {

}

/**
 * T is invariant : subtyping is not preserved
 * class Garden<T:Flower> {
 *  }
 * With out you are preserving the subtype for the runtime.
 * But with covariant we can read the covariant in the
 * out position .
 * in : function parameters
 * out : output
 */
class Garden<out T: Flower> {

    val flowers: List<T> = listOf()

    fun pickFlower(i: Int): T = flowers[i]

    /* This won't work because the T is an output parameter
       Also T is covariant . T can't be used as a parameter type
       This could lead to have a list with multiple lists . Subtyping is preserved
       fun plantFlower(flower: T)  {}
    */

}

/**
 * Class that accepts covariants as input
 * I could pass any class here .  Can't use var .
 * Must use val , It doesn't have a get .
 * "private var" also works
 */
class UnsafeGarden<out T:Flower>(val something: T) {
//try private var ... prevent outside world from adding wrong type of flower
//covariance the subtype must be preseverd
    val flowers: List<T> = listOf()

    fun pickFlowers(i: Int): T = flowers[i]

}