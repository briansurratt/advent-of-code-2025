package com.adventofcode.aoc2025.day2


import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test


class RangeParserTest {

    private val rangeParser = RangeParser()

    @Test
    fun simpleScenario() {

        val expected: IntRange = 1.rangeTo(5)
        val actual : IntRange = rangeParser.parse("1-5")

        assertEquals(expected, actual)

    }

    @Test
    fun `invalid range`() {

        val message = assertThrows(IllegalArgumentException::class.java) {
            rangeParser.parse("5-1")
        }.message

        assertEquals("Invalid range", message)

    }


}