package ar.com.miura.kotlin.io

import java.io.DataInputStream
import java.io.EOFException
import java.io.FileInputStream

/**
 * Reading binary files line by line
 * All the io is used like in Java
 */
fun main(args: Array<String>) {

    val di = DataInputStream(FileInputStream("src/main/resources/sample.txt"))
    var si: String

    try {
        while(true) {
            si = di.readUTF()
            println(si)
        }
    } catch (e:EOFException) {

    }

}