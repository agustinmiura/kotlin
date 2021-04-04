package ar.com.miura.kotlin.io

import java.io.File

fun main(args: Array<String>) {

    /**
     * First directories and then the files are visited
     */
    File(".").walkTopDown().forEach { println(it) }

    /**
     * Print only files
     */
    File(".").walkTopDown().filter { it -> it.name.endsWith(".kt") }.forEach { println(it) }

}