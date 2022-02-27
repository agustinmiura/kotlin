package ar.com.miura.fp

object Example {

    fun abs(n:Int): Int =
        if (n<0) -n
        else n

    fun factorial (i:Int): Int {
        fun go(n:Int, acum:Int): Int =
            if (n<=0) acum
            else go(n-1, n*acum)
        return go(i,1)
    }

    fun formatAbs(x: Int):String {
        val msg = "The absolute value of %d is %d"
        return msg.format(x, abs(x))
    }

    fun formatFactorial(x:Int):String {
        val msg = "The factorial is %d is %d"
        return msg.format(x, factorial(x))
    }

    fun formatResult(name:String, n:Int, f:(Int) -> Int):String {
        val msg = "The %s of %d is %d."
        return msg.format(name, n, f(n))
    }

    fun <A> findFirst(xs: Array<A>, key:A): Int {
        tailrec fun loop(n:Int): Int =
            when {
                n >= xs.size -> -1
                xs[n] == key -> n
                else -> loop(n+1)
            }
        return loop(0)
    }

}

fun main() {
    val anArray = arrayOf("first", "second")
    println(Example.findFirst(anArray, "first"))
    /*
    println(Example.formatResult("factorial", 7, ::factorial))
    println(Example.formatResult("absolute value", -42, ::abs))
    println(Example.formatResult("absolute", -42, { n -> if (n < 0) -n else n }))
    */
}
