package ar.com.miura.kotlin

import javax.print.attribute.standard.Destination

fun main(args:Array<String>) {

    val cars1 = mutableListOf(Car(), Car())
    val cars2: MutableList<Car> = mutableListOf()
    copyCars(cars1, cars2)

    val fords1 = mutableListOf(Ford(), Ford())
    val fords2: MutableList<Ford> = mutableListOf()
    //this would fail becuse generics don't preserve subtypes
    //generics are invariant
    //copyCars(fords1, fords2)
    copyCars(fords1, fords2)

    //This won't work
    //copyCars(fords1, cars2)

}

//this won't work
//fun copyCars(source: MutableList<Car>, destination: MutableList<Car>) {
/**
 * Here I am using sitevariance
 * A parameter is set as covariant/counter variant
 * Type proyection
 * covariance is List<? extends Car> in Java
 *
 * //this is counter variance in Java
 * List<? super Car>
 *
 *Java doesn't have any site variance  
 */
fun<T: Car> copyCars(source: MutableList<out T>, destination: MutableList<T>) {
    for(car in source) {
        destination.add(car)
    }
}

open class Car {

}

class Toyota: Car() {

}

class Ford: Car() {

}