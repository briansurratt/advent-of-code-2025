package com.adventofcode.aoc2025.day6

data class Problem(val width: Int = 0, private val operator: Operator) {

    private val numbers = mutableListOf<String>()

    enum class Operator {
        multiplication,
        addition;

        companion object {
            fun encode(char: Char): Operator {
                return when (char) {
                    '*' -> multiplication
                    '+' -> addition
                    else -> throw IllegalArgumentException(char.toString())
                }
            }
        }

    }

    fun addNumber(number: String) {
        println("number = [${number}]")
        numbers.add(number)
    }

    fun solve(): Long {

        println("Problem.solve")

        println(numbers)

        val longValues= numbers.map { it.trim() }.filterNot { it.isEmpty() }.map { it.toLong() }

        println("*******************")
        println(longValues)
        println(operator)
        println("*******************")



        val solution = when (operator) {
            Operator.multiplication -> longValues.fold(1L) { accumulator, element ->
                accumulator * element
            }

            Operator.addition -> longValues.sum()
        }

        return solution

    }

    fun solveV2(): Long {

        println("Problem.solveV2")
        numbers.forEach { s ->
            println("   [$s]")
        }
        
        val pivoter = NumberSeriesPivoter(width)
        val newNumbers = pivoter.process(numbers)

        val solution = when (operator) {
            Operator.multiplication -> newNumbers.fold(1L) { accumulator, element ->
                accumulator * element
            }

            Operator.addition -> newNumbers.sumOf { it.toLong() }
        }

        return solution



    }


}