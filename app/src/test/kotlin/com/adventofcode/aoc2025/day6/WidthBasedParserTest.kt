package com.adventofcode.aoc2025.day6

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class WidthBasedParserTest {

    @Test
    fun `simple`() {

        val widths = listOf<Int>(3,3,3,3)

        val widthBasedParser = WidthBasedParser(widths)

        val numbers = widthBasedParser.line("123 328  51 64 ")
        assertEquals(listOf("123", "328", " 51", "64 "), numbers)

        val numbers2 = widthBasedParser.line("  6 98  215 314")
        assertEquals(listOf("  6", "98 ", "215", "314"), numbers2)


    }


}