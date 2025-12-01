package com.adventofcode.aoc2025.day1

import com.adventofcode.util.DataSource

class Day1 {

    fun process() {

        val dial = Dial()


        val dataSource = DataSource()

//        val input = object {}.javaClass.getResourceAsStream("/day1/sample-data.txt")!!
        val input = object {}.javaClass.getResourceAsStream("/day1/input.txt")!!

        val fileContents = dataSource.load(input)

        val dataProcessor = DataProcessor()
        val turns = dataProcessor.process(fileContents)

        turns.forEach {
            dial.turn(it)
        }

        println("password = ${dial.passesZero} ")

    }

}

fun main() {
    Day1().process()
}
