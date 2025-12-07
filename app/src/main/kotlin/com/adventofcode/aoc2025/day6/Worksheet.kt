package com.adventofcode.aoc2025.day6

class Worksheet(val problems: List<Problem>) {

    private val lineParser = LineParser()

    enum class LineType {
        numbers, operators
    }


    fun addLine(newLine: String) {

        val multiply = newLine.contains('*')
        val addition = newLine.contains('+')

        val lineType = if (multiply || addition) {
            LineType.operators
        } else {
            LineType.numbers
        }

        when (lineType) {
            LineType.operators -> {
             // can discard this now
            }

            LineType.numbers -> {
                val numbers = lineParser.parseNumbers(newLine)
                addNumbers(numbers)
            }
        }

    }

    private fun addNumbers(numbers: List<String>) {

        for (i in 0..<problems.size) {
            problems[i].addNumber(numbers[i])
        }

    }



    fun calculateGrandTotal(): Long {

        return problems.sumOf { problem -> problem.solve() }

    }

    fun solvePart2(): Long {
        TODO("Not yet implemented")
    }

}