package com.adventofcode.aoc2025.day1

data class Turn(
     val direction: Direction,
     val quantity: Int) {

    fun delta() : Int {
        return Math.floorMod(quantity,100) * direction.multiplier
    }

}
