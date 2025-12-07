package com.adventofcode.aoc2025.day3

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class JoltageMaximizerTest {

    private val lineParser = LineParser()


    @ParameterizedTest(name = "Two Battery Test")
    @MethodSource("TwoBatteryTest")
    fun twoBatteryTest(line : String, expected: Long) {

        val sequence = lineParser.parse(line)
        val bank = Bank()

        sequence.forEach { i -> bank.addBatteryWithJoltage(i) }

        val maximizer = JoltageMaximizer(bank, 2)
        maximizer.run()

        val actual = bank.calculateJoltage()

        println("JoltageMaximizerTest.twoBatteryTest")
        println("   $expected")
        println("   $actual")

        assertEquals(expected, actual)

    }

    @ParameterizedTest(name = "Twelve Battery Test")
    @MethodSource("TwelveBatteryTest")
    fun twelveBatteryTest(line : String, expected: Long) {

        val sequence = lineParser.parse(line)
        val bank = Bank()

        sequence.forEach { i -> bank.addBatteryWithJoltage(i) }

        val maximizer = JoltageMaximizer(bank, 12)
        maximizer.run()

        val actual = bank.calculateJoltage()

        println("JoltageMaximizerTest.twelveBatteryTest")
        println("   $expected")
        println("   $actual")

        assertEquals(expected, actual )

    }


    companion object {
        @JvmStatic
        fun TwoBatteryTest() : Stream<Arguments> {

            return Stream.of(
                arguments("987654321111111", 98L),
                arguments("811111111111119", 89L),
                arguments("234234234234278", 78L),
                arguments("818181911112111", 92L)
            )

        }

        @JvmStatic
        fun TwelveBatteryTest() : Stream<Arguments> {

            return Stream.of(
                arguments("987654321111111", 987654321111L),
                arguments("811111111111119", 811111111119L),
                arguments("234234234234278", 434234234278L),
                arguments("818181911112111", 888911112111L)
            )

        }

    }

}