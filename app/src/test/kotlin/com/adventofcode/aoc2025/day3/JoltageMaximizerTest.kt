package com.adventofcode.aoc2025.day3

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class JoltageMaximizerTest {

    private val lineParser = LineParser()


    @ParameterizedTest
    @MethodSource("testParameters")
    fun test(line : String, expected: Long) {

        val sequence = lineParser.parse(line)
        val bank = Bank()

        sequence.forEach { i -> bank.addBatteryWithJoltage(i) }

        val maximizer = JoltageMaximizer(bank, 12)
        maximizer.run()

        assertEquals(expected, bank.calculateJoltage() )

    }


    companion object {
        @JvmStatic
        fun testParameters() : Stream<Arguments> {

            return Stream.of(
                arguments("987654321111111", 98L),
                arguments("811111111111119", 89L),
                arguments("234234234234278", 78L),
                arguments("818181911112111", 92L)
            )

        }
    }

}