package com.adventofcode.aoc2025.day6

class NumberSeriesPivoter(private val width: Int) {


    fun process(numbers: List<String>): List<Long> {

        numbers.forEach { println("[$it]") }

        val stringBuilders = List(numbers.size) { StringBuilder() }

        (0..<width).forEach { i ->
            numbers.forEach { line ->
                println("*$line*[$i]")
                stringBuilders[i].append(line[i])
            }
        }

        return  stringBuilders.map { it.toString().trim() }.filterNot { it.isEmpty() }.map { it.toLong() }.sorted()
    }

}