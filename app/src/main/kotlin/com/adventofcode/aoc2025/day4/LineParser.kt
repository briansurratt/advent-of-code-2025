package com.adventofcode.aoc2025.day4

class LineParser {

    fun parse(line: String) : MutableList<Boolean> {

        val booleans = line.map { c ->
            (c == '@')
        }

        return booleans.toMutableList()

    }

}