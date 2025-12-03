package com.adventofcode.aoc2025.day2


import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
class DateProcessorTest {

    private val dataProcessor = DataProcessor()

    @Test
    fun `two elements`() {

        val ranges = dataProcessor.process("11-22,95-115")

        assertEquals(2, ranges.size)
        assertEquals(11.rangeTo(22), ranges[0])
        assertEquals(95.rangeTo(115), ranges[1])

    }
    
}