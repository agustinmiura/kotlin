package ar.com.miura.fp

object Exercises {

  val <T> List<T>.tail: List<T>
    get() = drop(1)
  val <T> List<T>.head: T
    get() = first()

  fun <A> isSorted(aa: List<A>, order: (A, A) -> Boolean): Boolean {
    tailrec fun go(list: List<A>, orderFn: (A, A) -> Boolean): Boolean {
      return if (list.isEmpty() || list.size == 1)
        true
      else if (orderFn(list.head, list.tail.head))
        return go(list.tail, orderFn)
      else
        return false
    }
    return go(aa, order)
  }
}

fun main() {
  try {
    val strings = listOf("1", "2", "3")
    val order =
      fun(string1: String, string2: String): Boolean {
        return string1.compareTo(string2) <= 0
      }
    println(" Is sorted : " + Exercises.isSorted(strings, order))
  }catch(e:Exception) {
    e.printStackTrace()
  }
}
