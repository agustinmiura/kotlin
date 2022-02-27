package ar.com.miura.fp

object Exercises {

  val <T> List<T>.tail: List<T>
    get() = drop(1)
  val <T> List<T>.head: T
    get() = first()

  /*
  fun <A> isSorted(aa: List<A>, order: (A, A) -> Boolean): Boolean  {
      return false;
  }
  */

  fun isSorted(aa: List<String>):Boolean {
    fun go(first: String, list: List<String>): Boolean {
      if (!list.isEmpty()) {
        if (first.compareTo(list.head) <= 0) {
          return go(list.head, list.tail)
        } else {
          return false
        }
      } else {
        return true
      }
    }
    return go(aa.head, aa.tail)
  }
}

fun main() {
  val strings = listOf("1", "2","3")
  println(Exercises.isSorted(strings))
}
