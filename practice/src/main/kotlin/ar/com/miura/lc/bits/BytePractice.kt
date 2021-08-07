package ar.com.miura.lc.bits

fun main() {

    /**
     * OR operation
     */
    val orResult = 12 or 25

    /**
     * AND operation
     */
    val andResult = 12 and 25

    /**
     * XOR operation
     */
    val xorOperation = 12 xor 25

    /**
     * inv number
     */
    var invResult = 35.inv()

    /**
     * shift left positions
     * inserts zeros
     */
    var shiftLeft = (212 shl 1)
    shiftLeft = (212 shl 0)
    shiftLeft = (212 shl 4)

    /**
     * shift rigth operation
     */
    var shiftRight = (212 shr 1)
    println("ShiftRight : ${shiftRight} ")

    shiftRight = (212 shr 0)
    println("ShiftRight : ${shiftRight} ")

    shiftRight = (212 shr 8)
    println("ShiftRight : ${shiftRight} ")

    /**
     * Set bit
     */
    var number = Integer.parseInt("0100",2)
    var bit = BytePractice().getBit(number, 2)

    /**
     * Set bit
     */
    number = Integer.parseInt("0100",2)
    var newNumber = BytePractice().setBit(number, 1)

    /**
     * Clear bit
     */
    number = Integer.parseInt("10100",2)
    newNumber = BytePractice().clearBit(number, 2)

    /**
     * Update bit
     */
    number = Integer.parseInt("10100",2)
    newNumber = BytePractice().updateBit(number, 1, true)
    println(" Number is ${Integer.toBinaryString(newNumber)} ")

}

class BytePractice {

    /**
     *  This method shifts 1 over by i bits, creating a value that looks like 00010000. By performing an AND with
        num, we clear all bits other than the bit at bit i. Finally, we compare that to 0. If that new value is not zero,
        then bit i must have a 1. Otherwise, bit i is a 0.
     */
    fun getBit(number:Int, position:Int):Boolean {
        return (( number and (1 shl position) ) != 0)
    }

    /**
     *  Set Bit shifts 1 over by i bits, creating a value like 00010000. By performing an OR with num, only the
        value at bit i will change. All other bits of the mask are zero and will not affect num.
     */
    fun setBit(number:Int, position:Int):Int {
        return number or (1 shl position)
    }

    /**
     *  This method operates in almost the reverse of setBi t. First, we create a number like 11101111 by creating
        the reverse of it (00010000) and neg
     */
    fun clearBit(number:Int, position:Int):Int {
        var mask:Int = (1 shl position).inv()
        return (number and mask)
    }

    /**
     * To set the ith bit to a valuev, we first clear the bit at position i by using a mask that looks like 11101111.
        Then, we shift the intended value, v, left by i bits. This will create a number with bit i equal to v and all
        other bits equal to 0. Finally, we OR these two numbers, updating the ith bit if v is 1 and leaving it as 0
        otherwise.
     */
    fun updateBit(number:Int, position:Int, bitIsOne:Boolean):Int {
        val value = if (bitIsOne) { 1 } else { 0 }
        val mask = (1 shl position).inv()
        return (number and mask) or (value shl position)
    }
}