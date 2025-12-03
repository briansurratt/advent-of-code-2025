package com.adventofcode.aoc2025.day2

import com.adventofcode.util.DataSource
import java.util.function.Predicate

class Solution {

    fun run(predicate: Predicate<Long>) {

        val dataset = DataSource().load("/day2/puzzle.txt")
        val ranges = DataProcessor().process(dataset)

        val rangeProcessor = RangeProcessor(predicate)

        val answer = ranges.sumOf { range -> rangeProcessor.process(range) }

        println("answer is $answer")

    }

}

fun main() {
    Solution().run(PartTwoPredicate())
}