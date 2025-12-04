package com.adventofcode.aoc2025.day3

import java.lang.Integer.max
import kotlin.math.min

class JoltageMaximizer(private val bank: Bank, private  val batteriesToTurnOn: Int) {

    val bankSize = bank.size()
    var windowSize : Int = 0
    val joltages = bank.getJoltages().toList()
    val keepers = mutableListOf<BatteryReference>()

    fun run() {

        windowSize = bankSize - batteriesToTurnOn

        println(windowSize)

        var leftFinger = 0
        var rightFinger = bankSize - 1


        val range = leftFinger .. leftFinger + windowSize

        process(range)

        println(keepers)

//        println(range)
//
//        val pair = joltages.maxInWindow(range)
//        keepers.add(pair)
//
//        leftFinger = pair.second + 1
//
////        process()
//
//        val range2 = leftFinger .. min(leftFinger + windowSize, bankSize)
//        println(range2)
//        val pair2 = joltages.maxInWindow(range2)
//
//        println("pair = ${pair}")
//        println("pairs = ${pair2}")


    }

    private fun process(
        range: IntRange
    ) {

        val batteryReference = joltages.maxInWindow(range)

        keepers.add(batteryReference)
        println("keepers = ${keepers}")

        keepers.sortDescending()

        if (keepers.size > batteriesToTurnOn) {
            keepers.removeLast()
        }
//        println("keepers = ${keepers}")

        println(keepers.map { it -> it.index }.sorted().toList())

        val newStart = batteryReference.index + 1

        val newRange = newStart..min(newStart + windowSize, bankSize)

        process(newRange)

    }

    /**
     * given a range, find the highest value in range, returning the max value in that range and the first occurence
     * of the value in the sublist
     */
    fun List<Int>.maxInWindow(range: IntRange): BatteryReference {

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