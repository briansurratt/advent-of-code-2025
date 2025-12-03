package com.adventofcode.aoc2025.day2

import java.util.function.Predicate


class RepeatingNumberPredicate : Predicate<Long> {

    fun Int.isEven() : Boolean {
        return this % 2 == 0
    }

    override fun test(t: Long): Boolean {

        val stringForm = t.toString()

        val l = stringForm.length

        return if (l.isEven()) {
            val halfLength = l/2
            val firstHalf = stringForm.take(halfLength)
            val secondHalf = stringForm.takeLast(halfLength)
            return firstHalf == secondHalf
        } else {
            false
        }

    }

}