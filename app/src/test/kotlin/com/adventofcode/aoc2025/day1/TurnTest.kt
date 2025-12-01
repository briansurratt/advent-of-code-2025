package com.adventofcode.aoc2025.day1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TurnTest {

    @Test
    fun overflows() {

        assertEquals(-1, Turn(Direction.Left, 101).delta())
        assertEquals(3, Turn(Direction.Right, 203).delta())

    }


}