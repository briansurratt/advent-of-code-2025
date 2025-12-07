package com.adventofcode.aoc2025.day5

class FileProcessor {

    enum class Mode {
        range, ingredient
    }

    private  val ingredientDatabase  = IngredientDatabase()

    private var currentMode = Mode.range

    fun getDatabase() : IngredientDatabase {
        return ingredientDatabase
    }

    fun processLine(line : String) {

        if (line.isNullOrEmpty()) {
            currentMode = Mode.ingredient
            return
        }

        when (currentMode) {
            Mode.range -> processRange(line)
            Mode.ingredient -> processIngredient(line)
        }

    }

    private fun processRange(line: String) {

        val split = line.split("-")
        val freshRange = FreshRange(split[0].toLong(), split[1].toLong())
        ingredientDatabase.addRange(freshRange)

    }

    private fun processIngredient(line: String) {

        val id = line.toLong()
        val ingredient = Ingredient(id)
        ingredientDatabase.addIngredient(ingredient)

    }

}