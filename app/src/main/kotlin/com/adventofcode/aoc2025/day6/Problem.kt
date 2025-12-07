package com.adventofcode.aoc2025.day6

import kotlin.properties.Delegates

class Problem  {

    private lateinit var operator : Operator
    private val numbers = mutableListOf<String>()

    enum class Operator {
        multiplication,
        addition
    }

    fun setOperator(oprtr : Operator) {
        this.operator = oprtr
    }

    fun addNumber(number: String) {
        numbers.add(number)
    }

    fun solve() : Long {

        val solution = when (operator) {
            Operator.multiplication -> numbers.map { it.toLong()  }.fold(1L) { accumulator, element ->
                accumulator * element
            }
            Operator.addition -> numbers.sumOf { it.toLong() }
        }

        return solution

    }

    fun solveV2() : Long {

        // map back to String
        // pivot columns to rows
        // map back to Long
        // performOperation

        return 0L

    }


}