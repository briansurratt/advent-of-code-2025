package com.adventofcode.aoc2025.day2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RangeProcessorTest {

    private val predicate = PartOnePredicate()

    val processor = RangeProcessor(predicate)

    @Test
    fun `sample 1`() {

        val input = 11L.rangeTo(22L)
        val expected = 33.toLong()

        val actual = processor.process(input)

        assertEquals(expected, actual)

    }

    @Test
    fun `sample 2`() {

        val input = 95L.rangeTo(115L)
        val expected = 99.toLong()

        val actual = processor.process(input)

        assertEquals(expected, actual)

    }


}