package ar.com.miura.lc.dp

class ClimbingStairs {
    fun climbStairs(n: Int): Int {
        return climb(n)
    }

    private fun climb(n:Int):Int {
        var fibo:IntArray = IntArray(n+3)
        fibo[0]=0
        fibo[1]=1
        fibo[2]=2
        var index = 3
        while(index<=n) {
            fibo[index] = fibo[index-1] + fibo[index-2]
            index++
        }
        return fibo[n]
    }
}