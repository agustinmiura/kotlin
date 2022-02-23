package ar.com.miura.fp

class FpProgramming {

    fun factorial(i: Int): Int {
        fun go(n:Int, acc: Int): Int =
            if (n <= 0) acc
            else go(n - 1, n * acc)
        return go(i,1)
    }

    fun factorialTailRec(i: Int) : Int {
        tailrec fun go(n:Int, acc: Int): Int =
            if (n <= 0) acc
            else go(n-1, n * acc)
        return go(i,1)
    }

    fun fib(i: Int): Int {
        return if (i == 1) 0
        else if (i == 2) 1
        else fib(i - 1) + fib(i - 2)
    }

    fun fibAcum(i:Int):Int {
        fun go(i:Int,prev:Int, acum:Int): Int =
            if (i <= 0) acum
            else go(i-1, acum, prev + acum)
        return go(i, i-1, 0)
    }



}