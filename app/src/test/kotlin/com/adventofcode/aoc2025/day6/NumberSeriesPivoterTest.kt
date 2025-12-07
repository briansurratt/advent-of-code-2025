package com.adventofcode.aoc2025.day6

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class NumberSeriesPivoterTest {


    @ParameterizedTest
    @MethodSource("numberSource")
    fun test(numbers: List<String>, expected: List<Int>) {

        val pivoter = NumberSeriesPivoter(width = 3)
        val numbers: List<Long> = pivoter.process(numbers)

        assertEquals(expected.map { it.toLong() }.sorted(),numbers)

    }

    companion object {
        @JvmStatic
        fun numberSource(): Stream<Arguments> {

            return Stream.of(
                arguments(listOf("64 ", "23 ", "314"), listOf(4, 431, 623)),
                arguments(listOf(" 51", "387", "215"), listOf(175, 581, 32)),
                arguments(listOf("328", "64 ", "98 "), listOf(8, 248, 369)),
                arguments(listOf("123", " 45", "  6"), listOf(356, 24, 1))
            )


        }
    }

}