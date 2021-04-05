package ar.com.miura.kotlin.loop

fun main(args:Array<String>) {

    var collection = arrayOf("String1", "String2", "String3")

    /**
     * Simple loop
     */
    for(eachString in collection) {
        println("$eachString")
    }

    /**
     * Looping through the numbers
     */
    for(i in 1..3) {
        println(i)
    }

    /**
     * Looping with a step
     */
    for(i in 1..100 step 20) {
        println(i)
    }

    /**
     * While
     */
    var i = 10
    while(i<20) {
        i++;
        println(i)
    }

    /**
     * Breaks in loops
     */
    for(i in 1..100 step 20) {
        println(i)
        if (i>30) {
            break;
        }
    }

}