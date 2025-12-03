package com.adventofcode.aoc2025.day2

import java.util.function.Predicate

class RangeProcessor(private val predicate : Predicate<Long>){

    fun process(range: LongRange) : Long {

        return range
            .filter { value -> predicate.test(value) }
            .sum()

    }

}