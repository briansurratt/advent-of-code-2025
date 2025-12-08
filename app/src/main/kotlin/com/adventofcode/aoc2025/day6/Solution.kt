package com.adventofcode.aoc2025.day6

import com.adventofcode.util.DataSource

class Solution {

    fun run(type: DataSource.Type) {

        val data = DataSource().load(6, type)

        val lines = data.lines()

        val problemBuilder = ProblemBuilder()
        val problems = problemBuilder.processOperatorLiner(lines.last())

        val worksheet = Worksheet(problems)

        lines.forEach { line ->
            worksheet.addLine(line)
        }

//        val grandTotal : Long = worksheet.calculateGrandTotal()
//        println("grandTotal = ${grandTotal}")


        val grandTotal2 : Long =worksheet.solvePart2()
        println("grandTotal2 = ${grandTotal2}")
    }

}

fun main() {
    Solution().run(DataSource.Type.puzzle)
}