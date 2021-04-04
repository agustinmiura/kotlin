package ar.com.miura.kotlin.io

import java.io.File

fun main(args: Array<String>) {

    /**
     * new InputStreamReader(new FileInputStreamReader(new File..)
     */
    val file = File("src/main/resources/sample.txt")
    /**
     * For large files this can't be used and
     * closes the stream
     * Limit of 2gb
     */
    val lines = file.reader().readLines()
    lines.forEach { println(it) }

    /**
     * Opening and closing the reader
     *
     */
    val reader = file.reader()
    try {
        val lines2 = reader.readText()
        println(lines2)
    }finally {
        reader.close()
    }

    /**
     * This blocks closes automtaically same as
     * try () {
     *
     * }
     * Functions most of the times with use will
     * close the resource
     */
    val lines3 = file.reader().use { it.readText() }
    println(lines3)

    /**
     * Reads one line per time
     */
    file.reader().forEachLine { println(it) }

    /**
     * For each item in the sequence we print it
     */
    file.reader().useLines { it.forEach { println(it) } }

}