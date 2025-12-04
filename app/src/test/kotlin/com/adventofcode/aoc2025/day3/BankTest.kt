package com.adventofcode.aoc2025.day3

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.intArrayOf



class BankTest {

    val inputs = listOf(9, 1, 2, 4, 6, 8, 3, 5, 7)

    val defaultBank = Bank().apply {
        for (i in inputs) {
            addBatteryWithJoltage(i)
        }
    }

    @Test
    fun `can add battery for all legal joltage values`() {
        val bank = Bank()
        for (i in 0..9) {
            bank.addBatteryWithJoltage(i)
        }
    }

    @DisplayName("illegal joltage fail")
    @ParameterizedTest(name = "{0}")
    @ValueSource(ints = [ 11, 22, 99, -1])
    fun `illegal voltages fail`(joltage: Int) {

        val bank = Bank()
        assertThrows(IllegalArgumentException::class.java) {
            bank.addBatteryWithJoltage(joltage)
        }

    }

    @Test
    fun `getJoltages`() {

        val asSequence = inputs.asSequence()
        val joltages = defaultBank.getJoltages()
        assertEquals(inputs.size, joltages.count())
        val pairs = asSequence.zip(joltages)

        assertNull( pairs.firstOrNull { (a, b) -> a != b }, "There was a mismatch")

    }

    @Test
    fun `joltageInBatteryByIndex`() {


        inputs.forEachIndexed { index, expected ->
            assertEquals(expected, defaultBank.joltageAtIndex(index))
        }

    }

    @Test
    fun `getSize`() {

        val bank = Bank()
        for (i in inputs) {
            bank.addBatteryWithJoltage(i)
        }

        assertEquals(inputs.size, bank.size())

    }

    @Test
    fun `calculateJoltage defaults to 0`() {
        assertEquals(0,defaultBank.calculateJoltage())
    }

    @Test
    fun `turning batteries on and off changes joltage`() {

        val bank = Bank()

        LineParser().parse("987654321111").forEach { bank.addBatteryWithJoltage(it) }
        (1..bank.size()).forEach {
            println(it)
            bank.turnOn(it-1)
        }

        assertEquals(987654321111,bank.calculateJoltage())

        defaultBank.turnOn(3)
        assertEquals(4,defaultBank.calculateJoltage())
        defaultBank.turnOn(0)
        assertEquals(94,defaultBank.calculateJoltage())
        defaultBank.turnOff(3)
        assertEquals(9,defaultBank.calculateJoltage())
        defaultBank.turnOff(0)
    }

    @Test
    fun `apply`() {

        val bank = Bank().apply {
            addBatteryWithJoltage(5)
            addBatteryWithJoltage(2)
            addBatteryWithJoltage(1)
        }

        bank.applyMask(booleanArrayOf(true,true, true))
        assertEquals(521, bank.calculateJoltage())

        bank.applyMask(booleanArrayOf(true,true, false))
        assertEquals(52, bank.calculateJoltage())

        bank.applyMask(booleanArrayOf(false,true, false))

        assertEquals(2, bank.calculateJoltage())
        bank.applyMask(booleanArrayOf(false,false, false))

        assertEquals(0, bank.calculateJoltage())

    }

}