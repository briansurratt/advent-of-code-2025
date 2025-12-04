package com.adventofcode.aoc2025.day3

data class Battery(val joltage: Int) {

    var isOn = false

    fun turnOn() {
        isOn = true
    }

    fun turnOff() {
        isOn = false
    }

}
