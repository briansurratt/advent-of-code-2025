package com.adventofcode.aoc2025.day3

import kotlin.random.Random

class MaxedBasedJoltageMaximizer(val numberOfBatteries: Int) {

    fun run(bank: Bank) {

        val indexes = mutableListOf<Int>()

        (0..<numberOfBatteries).forEach { indexes.add(it) }

        val masks = generateMasks(numberOfBatteries, bank.size(), 100000)

        var max = 0L
        lateinit var maxMask: BooleanArray

        masks.forEach { mask ->
            bank.applyMask(mask)
            val joltage = bank.calculateJoltage()
            if (joltage > max) {
                max = joltage
                maxMask = mask
            }
        }

        bank.applyMask(maxMask)

    }

    private fun generateMasks(batteriesOn: Int, batteriesInBank: Int, masks: Int): List<BooleanArray> {

        val list = mutableListOf<BooleanArray>()

        for (i in 1..masks) {
            val candidate = generateMask(batteriesOn, batteriesInBank)
            list.add(candidate)
        }

        return list.distinct()

    }

    private fun generateMask(batteriesOn: Int, batteriesInBank: Int): BooleanArray {
        val batteriesToTurnOn = mutableListOf<Int>()

        do {
            val index = Random.nextInt(batteriesInBank - 1)
            if (!batteriesToTurnOn.contains(index)) {
                batteriesToTurnOn.add(index)
            }
        } while (batteriesToTurnOn.size < batteriesOn)

        val maskList = mutableListOf<Boolean>()

        for (i in 0..<batteriesInBank) {
            maskList.add(i, batteriesToTurnOn.contains(i))
        }

        return maskList.toBooleanArray()
    }

}