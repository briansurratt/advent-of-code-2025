package com.adventofcode.aoc2025.day6

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LineParserTest {

    @ParameterizedTest
    @MethodSource("numberSource")
    fun test(line: String, expected: List<Int>) {

        val lineParser = LineParser()
        val actual : List<String> = lineParser.parseNumbers(line)

        assertEquals(expected.map { it.toLong() }, actual)

    }

    @Test
    fun `operatorParse`() {

        val lineParser = LineParser()
        val operators = lineParser.parseOperators("*   +   *   +")

        assertEquals(Problem.Operator.multiplication, operators[0])
        assertEquals(Problem.Operator.addition, operators[1])
        assertEquals(Problem.Operator.multiplication, operators[2])
        assertEquals(Problem.Operator.addition, operators[3])


    }


    companion object {
        @JvmStatic
        fun numberSource(): Stream<Arguments> {

            return Stream.of(
                arguments("123 328  51 64", listOf(123, 328, 51, 64)),
                arguments("45 64  387 23", listOf(45, 64, 387, 23)),
                arguments("6 98  215 314", listOf(6, 98, 215, 314))
            )


        }
    }



}