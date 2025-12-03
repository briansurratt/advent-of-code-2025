package com.adventofcode.aoc2025.day2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RangeProcessorTest {

    val processor = RangeProcessor()

    @Test
    fun `sample 1`() {

        val input = 11.rangeTo(22)
        val expected = 33.toLong()

        val actual = processor.process(input)

        assertEquals(expected, actual)

    }

    @Test
    fun `sample 2`() {

        val input = 95.rangeTo(115)
        val expected = 99.toLong()

        val actual = processor.process(input)

        assertEquals(expected, actual)

    }


}