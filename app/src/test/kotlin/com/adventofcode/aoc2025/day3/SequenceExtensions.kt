package com.adventofcode.aoc2025.day3

    fun Sequence<Int>.equivalent(other: Sequence<Int>) : Boolean{

        if (this.count() != other.count()) {
            return false
        }

        val pairs = this.zip(other)
        val alignment = pairs.firstOrNull { (a, b) -> a != b }
        return alignment == null
    }
