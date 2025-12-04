package com.adventofcode.aoc2025.day3

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class JoltageCalculatorTest {

    private val lineParser = LineParser()
    private val calculator = JoltageCalculator()

    @ParameterizedTest
    @MethodSource("testParameters")
    fun test(line : String, expected: Int) {

        val sequence = lineParser.parse(line)
        val bank = Bank()
        sequence.forEach { i -> bank.addBatteryWithJoltage(i) }

        val calculated = calculator.calculate(bank)

        assertEquals(expected, calculated)


    }


    companion object {
        @JvmStatic
        fun testParameters() : Stream<Arguments> {

            return Stream.of(
                arguments("987654321111111", 98),
                arguments("811111111111119", 89),
                arguments("234234234234278", 78),
                arguments("818181911112111", 92)
            )

        }
    }

}

