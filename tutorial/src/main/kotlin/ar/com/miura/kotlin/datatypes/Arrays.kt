package ar.com.miura.kotlin.datatypes

fun main(args: Array<String>) {

    //type of the array
    val names = arrayOf("a", "b", "c")

    var nameArray:Array<String> = Array(100){ i -> "" }
    var otherIntArray = IntArray(5)

    //iterate
    for(name in names) {
        println("$name")
    }

    //mixed arays
    val mixed = arrayOf("String", 12, 12.1)

}