package com.adventofcode.aoc2025.day5

import kotlin.math.max
import kotlin.math.min


fun LongRange.intersects(other : LongRange) : Boolean {
    return check(this, other)
}

private fun check(r1: LongRange, r2: LongRange) : Boolean{
    return max(r1.first, r2.first) <= min(r1.last, r2.last)
}

fun LongRange.union(other :LongRange) : LongRange{
    return min(first, other.first)..max(last, other.last)
}
