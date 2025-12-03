package com.adventofcode.aoc2025.day2

class DataProcessor {

    fun process(data:String): List<LongRange> {

        val parser = RangeParser()

        return data.split(",")
            .map { range ->  parser.parse(range)}

    }

}