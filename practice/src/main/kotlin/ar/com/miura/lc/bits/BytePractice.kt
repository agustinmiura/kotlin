package ar.com.miura.lc.bits

import org.graalvm.compiler.java.BytecodeParser

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

    var number = Integer.parseInt("0100",2)
    var bit = BytePractice().getBit(number, 2)

    number = Integer.parseInt("0100",2)
    var newNumber = BytePractice().setBit(number, 1)
    println(" Number is ${Integer.toBinaryString(newNumber)} ")

    println(" Bit ${bit} ")

}

class BytePractice {

    fun getBit(number:Int, position:Int):Boolean {
        return (( number and (1 shl position) ) != 0)
    }

    fun setBit(number:Int, position:Int):Int {
        return number or (1 shl position)
    }


}