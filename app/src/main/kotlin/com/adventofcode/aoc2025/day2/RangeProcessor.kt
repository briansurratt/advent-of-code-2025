package com.adventofcode.aoc2025.day2

class RangeProcessor {

    private val predicate = RepeatingNumberPredicate()

    fun process(range: LongRange) : Long {

        println("range: $range")

        return range.filter { i -> predicate.test(i) }.sumOf { i -> i.toLong() }


    }

}