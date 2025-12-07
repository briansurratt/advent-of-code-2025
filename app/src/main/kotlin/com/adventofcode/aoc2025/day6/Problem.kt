package com.adventofcode.aoc2025.day6

import kotlin.properties.Delegates

class Problem  {

    private lateinit var operator : Operator
    private val numbers = mutableListOf<Long>()

    enum class Operator {
        multiplication,
        addition
    }

    fun setOperator(oprtr : Operator) {
        this.operator = oprtr
    }

    fun addNumber(number: Long) {
        numbers.add(number)
    }

    fun solve() : Long {

        val solution = when (operator) {
            Operator.multiplication -> numbers.fold(1L) { accumulator, element ->
                accumulator * element
            }
            Operator.addition -> numbers.sum()
        }

        return solution

    }

}