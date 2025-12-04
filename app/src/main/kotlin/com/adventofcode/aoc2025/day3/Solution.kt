package com.adventofcode.aoc2025.day3

import com.adventofcode.util.DataSource

class Solution {

    fun run() {

        val dataset = DataSource().load("/day3/puzzle.txt")

        val parser = LineParser()
        val calculator = JoltageCalculator()

        var accumulator = 0;

        dataset.lines().forEach { line ->

            val bank = Bank()

            parser.parse(line).forEach { joltage ->
                bank.addBatteryWithJoltage(joltage)
            }

            val bankJoltage = calculator.calculate(bank)

            accumulator += bankJoltage

        }

        println("answer = $accumulator")

    }

}

fun main() {
    Solution().run()
}