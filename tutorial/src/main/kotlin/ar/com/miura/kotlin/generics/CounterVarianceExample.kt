package ar.com.miura.kotlin

fun main(args: Array<String>) {

    val roseTender = object: FlowerCare<Rose2> {
        override fun prune(flower: Rose2) = println("I am pruning a rose !")
    }

    val roseGarden = Garden2<Rose2>(listOf(
            Rose2(),
            Rose2()
        ),
        roseTender
    )
    roseGarden.tendFlower(0)

    val flower3Tender = object: FlowerCare<Rose3> {
        override fun prune(flower2: Rose3) {
            println(" Pruning a rose 3 ")
        }
    }

    val flower3Garden = Garden2<Rose3>(
        listOf(
            Rose3(),
            Rose3(),
            Rose3()
        ),
        flower3Tender
    )
    flower3Garden.tendFlower(2)

    /**
     * The tender objects are doing the same actions
     * We are refactoring here
     */
    val defFlowerTender = object: FlowerCare<Flower2> {
        override fun prune(flower: Flower2) = println(" I am tending a flower")
    }
    val roseGarden3 = Garden2<Rose2>(
        listOf(
            Rose2(), Rose2()
        ),
        //This would fail
        //flower3Tender

        /*
        * with counter variance we start with a subclass
        * we accept instances of that class , subclasss or any of the
        * parents
        * From that upward counter variance
        * */
        defFlowerTender
    )
    roseGarden3.tendFlower(0)

    /**
     * When we use covariance we can't use them as return type
     * When we use counter variance we can't use them as input
     */



}

class Garden2<T: Flower2>(val flowers: List<T>, val flowerCare: FlowerCare<T>) {
    fun pickFlower(i: Int) = flowers[i]
    fun tendFlower(i: Int) {
        flowerCare.prune(flowers[i])
    }
}

open class Flower2(val name: String) {

}
class Rose2: Flower2("Rose2") {

}

class Rose3: Flower2("Rose3") {

}

/**
 * We accept T or any of the superclasses
 * We accept roses or parents of the rose
 */
interface FlowerCare<in T> {
    fun prune(flower: T)
    //out position
    //fun pick() :T
}
