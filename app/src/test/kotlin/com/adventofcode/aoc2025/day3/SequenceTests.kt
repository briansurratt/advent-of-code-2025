package com.adventofcode.aoc2025.day3

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SequenceTests {

    @Test
    fun `this should pass`() {

        val reference = sequenceOf(1,2,3)
        val subject = sequenceOf(1,2,3)

        assertEquals(true, reference.equivalent(subject))

    }


    @Test
    fun `this should fail - different order`() {

        val reference = sequenceOf(1,2,3)
        val subject = sequenceOf(2,3,1)

        assertEquals(false, reference.equivalent(subject))

    }



    @Test
    fun `this should fail - more`() {

        val reference = sequenceOf(1,2,3)
        val subject = sequenceOf(2,3,1,4)

        assertEquals(false, reference.equivalent(subject))

    }



    @Test
    fun `this should fail - less`() {

        val reference = sequenceOf(1,2,3)
        val subject = sequenceOf(1,2)

        assertEquals(false, reference.equivalent(subject))

    }

}

