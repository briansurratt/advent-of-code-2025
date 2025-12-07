package com.adventofcode.aoc2025.day6

class Worksheet {

    private val lineParser = LineParser()
    private val problems = mutableListOf<Problem>()

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
                val operators = lineParser.parseOperators(newLine)
                addOperators(operators)
            }

            LineType.numbers -> {
                val numbers = lineParser.parseNumbers(newLine)
                addNumbers(numbers)
            }
        }

    }

    private fun addNumbers(numbers: List<Long>) {

        if (problems.size == 0) {
            for (i in 1..numbers.size) {
                problems.add(Problem())
            }
        }

        for (i in 0..<problems.size) {
            problems[i].addNumber(numbers[i])
        }

    }

    private fun addOperators(operators: List<Problem.Operator>) {
        for (i in 0..<problems.size) {
            problems[i].setOperator(operators[i])
        }
    }

    fun calculateGrandTotal(): Long {

        return problems.sumOf { problem -> problem.solve() }

    }

}