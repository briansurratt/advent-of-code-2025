package com.adventofcode.aoc2025.day6

import com.sun.tools.javac.jvm.PoolConstant.LoadableConstant.String

class Worksheet(val problems: List<Problem>) {

    private val lineParser = LineParser()
    val widths = problems.map { it.width }

    enum class LineType {
        numbers, operators
    }

    init {
        println("Worksheet.init")
        println("widths = ${widths}")
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


                val parser = WidthBasedParser(widths)
                val values = parser.line(newLine)

                for (i in 0..<values.size) {
                    problems[i].addNumber(values[i])
                }


            }
        }

    }

    private fun addNumbers(numbers: List<String>) {

        for (i in 0..<problems.size) {
            problems[i].addNumber(numbers[i])
        }

    }



    fun calculateGrandTotal(): Long {
        val longs = problems.map { problem ->
            problem.solve()
        }

        println("solutions: ${longs}")
        
        return longs.sum()
        
    }

    fun solvePart2(): Long {
        return problems.sumOf { problem -> problem.solveV2() }
    }

}