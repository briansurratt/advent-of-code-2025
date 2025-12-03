package com.adventofcode.aoc2025.day2

import com.adventofcode.util.DataSource

class Solution {

    fun run() {

        val dataset = DataSource().load("/day2/puzzle.txt")
        val ranges = DataProcessor().process(dataset)

        val rangeProcessor = RangeProcessor()

        val answer = ranges.sumOf { range -> rangeProcessor.process(range) }

        println("answer is $answer")

    }


}

fun main() {
    Solution().run()
}