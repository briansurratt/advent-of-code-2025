package com.adventofcode.aoc2025.day5

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FreshRangeTest {

    @Test
    fun `should be true`() {

        val freshRange = FreshRange(3, 5)

        assertEquals(true, freshRange.includes(3))
        assertEquals(true, freshRange.includes(4))
        assertEquals(true, freshRange.includes(5))
    }

    @Test
    fun `should be false`() {

        val freshRange = FreshRange(3, 5)

        assertEquals(false, freshRange.includes(1))
        assertEquals(false, freshRange.includes(8))
        assertEquals(false, freshRange.includes(11))
        assertEquals(false, freshRange.includes(32))

    }

    @Test
    fun `hasIntersection`() {

        val alpha = FreshRange(10, 20)
        val bravo = FreshRange(5, 15)
        val charlie = FreshRange(18, 24)

        assertEquals(true, alpha.intersects(bravo))
        assertEquals(true, bravo.intersects(alpha))

        assertEquals(true, charlie.intersects(alpha))
        assertEquals(true, alpha.intersects(charlie))

        assertEquals(false, bravo.intersects(charlie))
        assertEquals(false, charlie.intersects(bravo))

    }

    @Test
    fun union() {

        val union = LongRange(10, 14).union(LongRange(12, 18))
        assertEquals(10, union.first)
        assertEquals(18, union.last)

        val moreUnion = union.union(LongRange(16, 20))

        assertEquals(10, moreUnion.first)
        assertEquals(20, moreUnion.last)

    }

    @Test
    fun `total`() {
        assertEquals(3L, FreshRange(3,5).total())
        assertEquals(11L, FreshRange(10,20).total())


    }

}