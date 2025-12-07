package com.adventofcode.aoc2025.day6

import com.adventofcode.util.DataSource

class Solution {

    fun run(type: DataSource.Type) {

        val data = DataSource().load(6, type)
        val worksheet = Worksheet()

        val lines = data.lines()
        lines.forEach { line ->
            worksheet.addLine(line)
        }

        val grandTotal : Long = worksheet.calculateGrandTotal()
        println("grandTotal = ${grandTotal}")

    }

}


fun main() {
    Solution().run(DataSource.Type.puzzle)
}