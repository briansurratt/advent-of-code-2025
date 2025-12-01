package com.adventofcode.aoc2025.day1

import kotlin.time.Duration

enum class Direction(val abbr: Char, val multiplier: Int) {
    Left('L', -1),
    Right('R', 1);

    companion object {

        private val mapping = entries.associateBy { it.abbr }

        fun lookup(abbr: Char) : Direction{
            return mapping[abbr]?:throw IllegalArgumentException()
        }
    }
}