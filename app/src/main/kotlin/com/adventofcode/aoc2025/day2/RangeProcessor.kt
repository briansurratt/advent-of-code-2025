package com.adventofcode.aoc2025.day2

import java.util.function.Predicate

class RangeProcessor(private val predicate : Predicate<Long>){

    fun process(range: LongRange) : Long {

        println("range: $range")

        return range.filter { i -> predicate.test(i) }.sumOf { i -> i.toLong() }


    }

}