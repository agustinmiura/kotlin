package ar.com.miura.kotlin.datatypes

fun main(args: Array<String>) {

    var string = "string"
    //we can't do this
    //string = null

    var nullableString:String? = null

    if (nullableString != null) {
        println(" The variable is : ${nullableString.toUpperCase()} ")
    }
    //if it isn't null safe call operator
    println(nullableString?.toUpperCase())

    val str2: String = nullableString?:"Default value"

}