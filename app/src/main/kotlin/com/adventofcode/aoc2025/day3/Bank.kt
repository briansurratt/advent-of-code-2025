package com.adventofcode.aoc2025.day3

import kotlin.math.pow

class Bank {

    private val batteries = mutableListOf<Battery>()



    fun addBatteryWithJoltage(joltage : Int) {

        if (joltage !in 0..9) {
            throw IllegalArgumentException()
        }

        batteries.add(Battery(joltage))
    }

    fun getJoltages() : Sequence<Int> {

        return batteries.asSequence().map { battery-> battery.joltage }

    }

    fun joltageAtIndex(index: Int): Int {
        return batteries[index].joltage
    }

    fun size(): Int {
        return batteries.size
    }

    fun calculateJoltage() : Long {
        return batteries
            .filter { battery -> battery.isOn }
            .reversed()
            .withIndex()
            .sumOf {
                10.toDouble().pow(it.index).toLong() * it.value.joltage
            }
    }

    fun turnOn(index: Int) {
        batteries[index].turnOn()
    }

    fun turnOff(index: Int) {
        batteries[index].turnOff()
    }

    fun applyMask(mask: BooleanArray) {
        if (mask.size != batteries.size) {
            throw IllegalArgumentException("mask size (${mask.size}) is incorrect for bank (${batteries.size})")
        }

        mask.forEachIndexed { index, bool ->
            if (bool) {
                batteries[index].turnOn()
            } else {
                batteries[index].turnOff()
            }
        }

    }

}