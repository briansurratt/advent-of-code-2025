package com.adventofcode.aoc2025.day6

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ProblemBuilderTest {

    @Test
    fun `sampleLine`() {

        val problemBuilder = ProblemBuilder()
        val problems = problemBuilder.processOperatorLiner("*   +   *   +  ")


        assertEquals(3, problems[0].width)
        assertEquals(3, problems[1].width)
        assertEquals(3, problems[2].width)
        assertEquals(3, problems[3].width)



    }

}