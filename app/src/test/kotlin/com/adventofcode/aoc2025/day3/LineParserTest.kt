package com.adventofcode.aoc2025.day3

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LineParserTest {

    @Test
    fun `happy path`() {
        val lineParser = LineParser()

        val expected = sequenceOf(2, 3, 4, 2, 3, 4, 2, 3, 4, 2, 3, 4, 2, 7, 8)

        val actual = lineParser.parse("234234234234278")

        assertEquals(true, expected.equivalent(actual))

    }

}