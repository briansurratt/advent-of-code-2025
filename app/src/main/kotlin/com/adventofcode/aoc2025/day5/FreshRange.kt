package com.adventofcode.aoc2025.day5



class FreshRange(val start: Long, val stop: Long) {

    private val range = start..stop

    fun includes(id: Long): Boolean {
        return id in range
    }

    override fun toString(): String {
        return "FreshRange(range=${range})"
    }

    fun intersects(otherRange: FreshRange) : Boolean {
        return this.range.intersects(otherRange.range)
    }

    fun union(otherRange: FreshRange) : FreshRange {
        val newRange = this.range.union(otherRange.range)
        return FreshRange(newRange.first, newRange.last)
    }

    fun total(): Long {
        val lng = range.last - range.first + 1
//        println("${range.first}..${range.last}: $lng")
        return lng
    }

}
