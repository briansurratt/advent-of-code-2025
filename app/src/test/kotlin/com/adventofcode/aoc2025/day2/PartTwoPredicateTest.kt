package com.adventofcode.aoc2025.day2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.intArrayOf

class PartTwoPredicateTest {

    val predicate = PartTwoPredicate()

    @DisplayName("ints with repeated values")
    @ParameterizedTest(name = "{index}: {0}")
    @ValueSource(ints = [ 11, 22, 99,111,1010,1188511885,222222,565656,446446,38593859,824824824,2121212121])
    fun `test returns true`(toTest : Int) {
        assertEquals(true, predicate.test(toTest.toLong()))
    }

    @DisplayName("ints that do not have repeated values")
    @ParameterizedTest(name = "{index}: {0}")
    @ValueSource(ints = [ 12,121, 1234123,2345])
    fun `test returns false`(toTest : Int) {
        assertEquals(false, predicate.test(toTest.toLong()))
    }

}