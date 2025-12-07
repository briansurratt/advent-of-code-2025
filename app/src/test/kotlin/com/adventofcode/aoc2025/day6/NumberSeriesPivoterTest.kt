package com.adventofcode.aoc2025.day6

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import java.util.stream.Stream

class NumberSeriesPivoterTest {

    companion object {
        @JvmStatic
        fun numberSource(): Stream<Arguments> {

            return Stream.of(
                arguments(listOf(123, 328, 51, 64), listOf(4,431,623)),
                arguments( listOf(45, 64, 387, 23), listOf(175, )),
                arguments( listOf(6, 98, 215, 314))
            )


        }
    }

}