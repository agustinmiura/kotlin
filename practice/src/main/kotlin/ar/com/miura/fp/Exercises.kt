package ar.com.miura.fp

import ar.com.miura.fp.Exercises.show

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

  fun Int.show():String = "The value of this int is $this "

  fun <A, B, C> curry(f: (A, B) -> C): (A) -> (B) -> C =
    { a:A -> { b:B -> f(a,b) } }

  fun <A, B, C> uncurry(f: (A) -> (B) -> C): (A, B) -> C =
    { a:A , b:B -> f(a)(b) }

  fun <A, B, C> compose(f: (B) -> C, g: (A) -> B): (A) -> C =
    { a:A -> f(g(a))}

}

fun main() {
  try {
    val strings = listOf("1", "2", "3")
    println(" Is sorted : " + Exercises.isSorted(strings, { a:String, b:String -> a.compareTo(b)<=0 }))
    val int = 10
    println(" The val is ${int.show()} ")
  }catch(e:Exception) {
    e.printStackTrace()
  }
}
