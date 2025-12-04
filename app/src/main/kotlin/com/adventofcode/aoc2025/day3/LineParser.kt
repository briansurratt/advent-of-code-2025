package com.adventofcode.aoc2025.day3

class LineParser {

    fun parse(line: String) : Sequence<Int> {

        return line.toCharArray().map { c -> c.toString().toInt() }.asSequence()

    }

}