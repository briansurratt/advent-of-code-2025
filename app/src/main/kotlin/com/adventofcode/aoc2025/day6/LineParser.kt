package com.adventofcode.aoc2025.day6

class LineParser {
    fun parseNumbers(line: String): List<Long> {
        val split = line.split(" ")
        return split
            .filterNot { it.isEmpty() }
            .map { it.toLong() }

    }

    fun parseOperators(line: String): List<Problem.Operator> {
        val split = line.split(" ")

        return split
            .filterNot { it.isEmpty() }
            .map { it ->
            val op = if (it.equals("*")) {
                Problem.Operator.multiplication
            } else {
                Problem.Operator.addition
            }
            println("$it -> $op")
            op
        }
    }

}