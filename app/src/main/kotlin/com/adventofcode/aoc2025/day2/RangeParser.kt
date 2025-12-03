package com.adventofcode.aoc2025.day2

class RangeParser {
    fun parse(string: String): LongRange {

        val numbers = string.split("-")
            .map { it.toLong() }

        if (numbers[1] < numbers[0]) {
            throw IllegalArgumentException("Invalid range")
        }

        return numbers[0].rangeTo(numbers[1])
    }

}