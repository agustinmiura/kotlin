package ar.com.miura.kotlin.generics

fun main(args: Array<String>) {

    val joe = Person("Joe", "Jones", 45)
    val jane = Person("Jane", "Smith", 42)
    val mary = Person("Mary", "Mary", 50)
    val jean = Person("Jean2", "Jean2", 77)

    val (fName, lName, age) = joe
    println("fName = $fName , lName = $lName , age = $age ")

    val people = mapOf(
        "Jones" to joe,
        "Jane" to jane
    )

    println(people.count { x -> x.value.lastName == "Jones" })

    val namePairs = people.map { Pair(it.value.firstName, it.value.lastName) }
    println(namePairs)

    val firstName = people.map { it.value.firstName }
    val lastName = people.map { it.value.lastName }

}

class Person(val firstName: String, val lastName: String, val age:Int) {
    operator fun component1() = firstName
    operator fun component2() = lastName
    operator fun component3() = age
}