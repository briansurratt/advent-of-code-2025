package com.adventofcode.aoc2025.day1

class DataProcessor {

    fun process(data: String) : List<Turn> {

        val lineMapper = LineMapper()

        val lines = data.lines()
        val turns = lines.map { lineMapper.map(it) }

        return turns

    }

}


