package com.adventofcode.aoc2025.day6

class LineParser {
    fun parseNumbers(line: String): List<String> {
        val split = line.split(" ")
        return split
            .filterNot { it.isEmpty() }

    }

    fun parseOperators(line: String): List<Problem.Operator> {
        val split = line.split(" ")

        return split
            .filterNot { it.isEmpty() }
            .map { it ->
            val op = if (it == "*") {
                Problem.Operator.multiplication
            } else {
                Problem.Operator.addition
            }
            println("$it -> $op")
            op
        }
    }



}