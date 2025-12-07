package com.adventofcode.util

import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.ByteArrayInputStream
import java.io.File
import java.io.FileInputStream
import java.io.InputStream
import java.util.stream.StreamSupport




class DataSource() {

    fun load(file: File) : String {

        if (!file.exists()) {
            throw IllegalStateException("file ${file.absoluteFile} does not exist")
        }

        if (!file.canRead()) {
            throw IllegalStateException("file ${file.absoluteFile} can not be read")
        }

        return load(file.inputStream())

    }

    fun load(resourcePath: String) : String {
        val inputStream = object {}.javaClass.getResourceAsStream(resourcePath)!!
        return load((inputStream))
    }

    fun load(inputStream: InputStream) : String {
        val bis = BufferedInputStream(inputStream)
        val string = bis.bufferedReader().use { it.readText() }
        return string
    }

    fun load (day : Int,type : Type) : String {
        val resourcePath = "/day$day/${type.name}.txt"
//            /day5/sample.txt
        println("resourcePath = ${resourcePath}")
        return load(resourcePath)
    }

    enum class Type {
        sample, puzzle
    }

}