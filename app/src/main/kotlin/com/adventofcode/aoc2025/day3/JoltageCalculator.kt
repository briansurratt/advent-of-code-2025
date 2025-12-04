package com.adventofcode.aoc2025.day3

class JoltageCalculator {

    fun calculate(bank: Bank) : Int {

        val list = bank.getJoltages().toList()
        val allButOne = list.take(list.size - 1)
        val max = allButOne.max()
        val first = allButOne.indexOfFirst { i -> i == max }

        val subList = list.drop(first + 1)
        val secondMax = subList.max()

        return max * 10 + secondMax

    }

}