package com.adventofcode.aoc2025.day2


import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
class DateProcessorTest {

    private val dataProcessor = DataProcessor()

    @Test
    fun `two elements`() {

        val ranges = dataProcessor.process("11-22,95-115")

        assertEquals(2, ranges.size)
        assertEquals(11L.rangeTo(22L), ranges[0])
        assertEquals(95L.rangeTo(115L), ranges[1])

    }
    
}