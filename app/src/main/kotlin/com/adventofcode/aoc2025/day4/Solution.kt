package com.adventofcode.aoc2025.day4

import com.adventofcode.util.DataSource

class Solution {

    fun run() {

        val parser = LineParser()
//        val rawData = DataSource().load("/day4/sample.txt")
        val rawData = DataSource().load("/day4/puzzle.txt")

        val parsedData: List<MutableList<Boolean>> = rawData.lines().map { line -> parser.parse(line) }

        val warehouse = Warehouse(parsedData)

        var accumulator = 0
        var stop = false

        do {
            val rolls : Int = warehouse.countAccessible()
            if( rolls > 0) {
                accumulator = accumulator + rolls
            }  else {
                stop = true
            }
        } while (!stop)

        println(accumulator)


    }

}

fun main() {
    Solution().run()
}