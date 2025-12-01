package com.adventofcode.aoc2025.day1

class LineMapper() {

    fun map(line: String) : Turn {

        val d: Char = line[0]
        val q = line.substring(1)

        return Turn(
            Direction.lookup(d),
            q.toInt()
        )

    }

}