package ar.com.miura.lc.bits

fun main() {

    var number:Int = Integer.parseInt("00000010100101000001111010011100", 2)

    var reversed = ReverseBit().reverse(number)
    println(" Number : ${number} , reversed : ${reversed} ")

}

class ReverseBit {

    /**
     * Good solution
     */
    fun reverseBits(n: Int): Int {
        var result = 0
        var power = 31
        var numberToProcess = n
        while (numberToProcess != 0 && power >= 0) {
            var partial = (numberToProcess and 1) shl power
            result += partial
            numberToProcess = numberToProcess shr 1
            power--
        }
        return result
    }

    /**
     * Using unsigned ints this can lead to overflow
     */
    public fun reverse(number:Int):Double {
        var result = 0.0
        var power = 31
        var numberToProcess = number

        while(numberToProcess!=0 && power>=0) {

            /**
             * We can't add a negative number we have to add
             * 2 pow 31
             */
            if (power==31 && getBit(numberToProcess,31)) {
                result += Math.pow(2.0,power*1.0)

            } else {
                var partial = (numberToProcess and 1) shl power
                result += partial

            }

            println(" Result is : ${result} , pow: ${power}")

            numberToProcess = numberToProcess shr 1
            power--
        }

        return result
    }

    /**
     * True:1,
     * False:0
     */
    private fun getBit(number:Int, position:Int):Boolean {
        return ( number and (number shl position) != 0)
    }

}