package com.adventofcode.aoc2025.day6

class ProblemBuilder {

    private val ops = listOf('*', '+')

    fun processOperatorLiner(line : String) : List<Problem> {

        val chars = ArrayDeque<Char>()

        val problems = mutableListOf<Problem>()

        line.forEach { c ->

            if (chars.size == 0) {
                chars.addLast(c)
            } else {
                chars.addLast(c)
                if (c in ops) {

                    val previousOperator = chars.removeFirst()
                    var spaces = 0

                    while (chars[0] == ' ') {
                        spaces++
                        chars.removeFirst()
                        println("[$chars]")
                    }

                    val operator = Problem.Operator.encode(previousOperator)
                    problems.add(Problem(spaces, operator))

                }
            }

            println("[$chars]")

        }

        if (chars.isNotEmpty()) {
            val operator = Problem.Operator.encode(chars[0])
            problems.add(Problem(chars.size, operator))
        }

        return problems

    }

}