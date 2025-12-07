package com.adventofcode.aoc2025.day3

import kotlin.math.min

class JoltageMaximizerStack(private val bank: Bank, private  val batteriesToTurnOn: Int) {

    val stack = ArrayDeque(emptyList<Int>())





    val bankSize = bank.size()
    var windowSize : Int = 0
    val joltages = bank.getJoltages().toList()
    val keepers = mutableListOf<BatteryReference>()

    fun run() {

        windowSize = bankSize - batteriesToTurnOn

        println(windowSize)

        processRight(0..windowSize)

        val maxIndex = keepers.maxOf { it.index }
        val minIndex = keepers.minOf { it.index }
        val minValue = keepers.minOf { it.value }

        println("minIndex = $minIndex")
        println("maxIndex = $maxIndex")
        println("minValue = $minValue")

        println(keepers)

        processLeft(minIndex + 1..maxIndex)

        val indexes  = keepers.map { reference -> reference.index }
        val mask = buildMask(indexes, bankSize)

        bank.applyMask(mask)

    }

    private fun processLeft(range: IntRange) {

        val subList = joltages.subList(range.first, range.last)
        val maxInWindow = subList.maxInWindow(range)

        val smallestJoltage = keepers.minOf { batteryReference -> batteryReference.value }

        if (maxInWindow.value > smallestJoltage) {
            keepers.add(maxInWindow)
            keepers.sortBy { batteryReference -> batteryReference.index }
            val toRemove = keepers.first { batteryReference -> batteryReference.value == smallestJoltage }
            keepers.remove(toRemove)
        }

    }

    private fun processRight(
        range: IntRange
    ) {

        val batteryReference = joltages.maxInWindow(range)

        keepers.add(batteryReference)
        keepers.sortDescending()

        if (keepers.size > batteriesToTurnOn) {
            keepers.removeLast()
        }

//        println(keepers.map { it -> it.index }.sorted().toList())

        val newStart = batteryReference.index + 1

        if (newStart < bankSize) {
            val newRange = newStart..min(newStart + windowSize, bankSize)
            processRight(newRange)
        }

    }

    /**
     * given a range, find the highest value in range, returning the max value in that range and the first occurence
     * of the value in the sublist
     */
    fun List<Int>.maxInWindow(range: IntRange): BatteryReference {

        println("range = ${range}")

        val subList = this.subList(range.first, range.last)
        val max = subList.max()
        val index = subList.indexOfFirst { value -> value == max }

        return BatteryReference(index + range.first, max)
    }

    private fun buildMask(indexes: List<Int>, size: Int): BooleanArray {
        val maskList = mutableListOf<Boolean>()

        for (i in 0..<size) {
            maskList.add(i, indexes.contains(i))
        }

        return maskList.toBooleanArray()
    }

    data class BatteryReference(val index : Int, val value: Int) : Comparable<BatteryReference> {
        override fun compareTo(other: BatteryReference): Int {
            return value.compareTo(other.value)
        }
    }

}

//   val indexes: List<Int> = (0..<batteriesToTurnOn).toList()
//
//        var maxJoltage = 0L
//        lateinit var maxMask : BooleanArray
//
//        val size = bank.size()
//
//        val mask = buildMask(indexes, size)
//
//        bank.applyMask(mask)
//
//        maxJoltage = bank.calculateJoltage()
//        maxMask = mask
//
//        var finger = batteriesToTurnOn
//
//        do {
//            finger -= 1
//
//            val candidateIndexes = mutableListOf<Int>().apply {
//                addAll(indexes)
//            }
//
//            println("finger = ${finger}")
//
//            for (i in finger..<size) {
////            println("i = ${i}")
//                candidateIndexes[finger] = i
//                val candidateMask = buildMask(candidateIndexes, size)
//                bank.applyMask(candidateMask)
//                val j = bank.calculateJoltage()
//                println(candidateIndexes + "; " + j)
//                if (j > maxJoltage) {
//                    maxJoltage = j
//                    maxMask = candidateMask
//                }
//            }
//
//
//        } while (finger > 0)
//
//        bank.applyMask(maxMask)