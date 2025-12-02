package com.adventofcode.aoc2025.day1

import kotlin.math.absoluteValue

class Dial() {

    private var currentState: Int = 50

    var stopsOnZero = 0
    var passesZero = 0

    fun turn(turn: Turn) {

        val tick = 1 * turn.direction.multiplier

        (1..turn.quantity).forEach { _ ->
            currentState += tick
            if (currentState < 0) {
                currentState = 99
            } else if (currentState > 99) {
                currentState = 0
            }

            if (currentState == 0) {
                passesZero++
            }
        }

        if (currentState == 0) {
            stopsOnZero++
        }

    }

    fun getCurrentState(): Int {
        return currentState
    }

}

