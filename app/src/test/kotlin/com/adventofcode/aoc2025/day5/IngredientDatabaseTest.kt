package com.adventofcode.aoc2025.day5

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class IngredientDatabaseTest {

    @Test
    fun `hack it out`() {

        val database = IngredientDatabase()

        database.addRange(FreshRange(3,5))


        database.addIngredient(Ingredient(1))
        database.addIngredient(Ingredient(2))
        database.addIngredient(Ingredient(3))
        database.addIngredient(Ingredient(4))
        database.addIngredient(Ingredient(5))
        database.addIngredient(Ingredient(6))

        assertEquals(3, database.countSpoiledIngredients())

    }


}