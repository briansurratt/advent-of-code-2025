package com.adventofcode.aoc2025.day5

import com.adventofcode.util.DataSource

class Solution {

    fun solve(path: String) {

        val rawData = DataSource().load(path)

        val fileProcessor = FileProcessor()

        rawData.lines().forEach { line ->
            fileProcessor.processLine(line)
        }

        val database = fileProcessor.getDatabase()
        println(database.numberOfRanges())
        database.consolidate()
        println(database.numberOfRanges())


        println("total = ${database.getTotal()}")
        println("spoiled = ${database.getSpoiled()}")
        println("fresh = ${database.getFresh()}")

        println(database.countPossibleFreshIngredients())

    }

}

fun main() {
//    Solution().solve("/day5/sample.txt")
    Solution().solve("/day5/puzzle.txt")
}