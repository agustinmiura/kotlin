package ar.com.miura.kotlin.equality

fun main(args: Array<String>) {

    var employee = Employee("Blue", "Ford", 11)
    var employee2 = Employee("Blue", "Ford", 11);
    var employee3 = Employee("Blue", "Ford", 12);

    println(" e vs e2 :  ${employee==employee2}")
    println(" e vs e3 : ${employee2==employee3}")
    println(" e === e2 : ${employee === employee2 }")
    println(" e === e3 : ${employee2 === employee3}")


}

class Employee(var color:String,var brand: String,var age: Int) {

    override fun equals(obj: Any?):Boolean {
        /*instance of
        * */
        if (obj is Employee) {
            return color == obj.color && brand == obj.brand && age == obj.age

        } else {
            return false;

        }
    }
}


