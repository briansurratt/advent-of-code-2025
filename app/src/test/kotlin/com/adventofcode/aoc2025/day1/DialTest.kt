package com.adventofcode.aoc2025.day1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DialTest {

    val dial = Dial()

    fun Dial.turn(direction: Direction, quantity: Int) : Int {
        this.turn(Turn(direction, quantity))
        return this.getCurrentState()
    }

    @Test
    fun simpleUseCases() {

        assertEquals(0, dial.turn(Direction.Right, 50))
        assertEquals(12, dial.turn(Direction.Right, 12))

    }

    @Test
    fun moreThan100() {
//        assertEquals(50,dial.turn(Direction.Left, 400))
        assertEquals(49,dial.turn(Direction.Left, 401))
    }

    @Test
    fun leftOfZero() {
        assertEquals(0,dial.turn(Direction.Left, 50))
        assertEquals(95,dial.turn(Direction.Left, 5))
    }

}
