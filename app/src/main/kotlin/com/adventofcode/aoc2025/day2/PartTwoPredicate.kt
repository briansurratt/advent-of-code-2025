package com.adventofcode.aoc2025.day2

import java.util.function.Predicate
import java.util.regex.Pattern


class PartTwoPredicate : Predicate<Long> {

    private val partOnePredicate = PartOnePredicate()

    override fun test(t: Long): Boolean {

        return if (!partOnePredicate.test(t)) {
            val stringForm = t.toString()
            val length = stringForm.length
            val halfLength : Int = length/2

            val chunks = 1..halfLength
            chunks.forEach { chunkSize ->
                val sample = stringForm.take(chunkSize)
                val regex = Regex("($sample)+")
                val matches: Boolean = stringForm.matches(regex)
                if (matches) {
                    return true
                }
            }
            return false
        } else {
            true
        }

    }

}