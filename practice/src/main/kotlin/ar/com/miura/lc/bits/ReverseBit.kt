package ar.com.miura.lc.bits

fun main() {

    var number:Int = Integer.parseInt("00000010100101000001111010011100", 2)

    var reversed = ReverseBit().reverse(number)
    println(" Number : ${number} , reversed : ${reversed} ")

}

class ReverseBit {

    fun reverse(number:Int):Int {
        var result = 0
        var power = 31
        var numberToProcess = number

        while(numberToProcess!=0) {
            var partial = (numberToProcess and 1) shl power
            result += partial
            numberToProcess = numberToProcess shr 1
            power--
        }

        return result
    }

}