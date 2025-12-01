package com.adventofcode.aoc2025.day1

import kotlin.math.absoluteValue

data class Dial(private var currentState: Int =50) {

    var stopsOnZero = 0
    var passesZero = 0

    fun turn(turn: Turn) {

        for (i in 1..turn.quantity) {
//            print("${turn.direction.abbr}")
            currentState += (1 * turn.direction.multiplier)
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

    fun getCurrentState() : Int {
        return currentState
    }

}

