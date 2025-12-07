package com.adventofcode.aoc2025.day5

class IngredientDatabase {

    private val freshRanges = mutableListOf<FreshRange>()

    private val ingredients = mutableListOf<Ingredient>()

    private val freshIds = mutableSetOf<Long>()

    private var total = 0L
    private var fresh = 0L
    private var spoiled = 0L

    fun getTotal() : Long {
        return total
    }
    fun getFresh() : Long {
        return fresh
    }
    fun getSpoiled() : Long {
        return spoiled
    }

    private var numberOfIngredients = 0L

    fun addRange(range: FreshRange) {
        freshRanges.add(range)
    }

    fun consolidate() {

        var changed = false

        do {
            changed = consolidateLoop()
        } while (changed)


    }

    private fun consolidateLoop() : Boolean {

        val start = freshRanges.size

        freshRanges.sortBy { range -> range.start }

        val workingArray : Array<FreshRange?> = freshRanges.toTypedArray()

        (workingArray.forEach { println (it) })

        val s = workingArray.size
        for (i in workingArray.size - 1 downTo 1) {

            val current: FreshRange = workingArray[i]!!
            val previous: FreshRange = workingArray[i-1]!!

            if (current.intersects(previous)) {
                val union = current.union(previous)
                workingArray[i] = null
                workingArray[i-1] = union
            }

        }

        freshRanges.clear()

        workingArray.forEach {
            if(it != null) {
                freshRanges.add(it)
            }
        }

        println(freshRanges.size)

        val end = freshRanges.size

        return (start != end)

    }


    fun addIngredient(ingredient: Ingredient) {
        println("add ingredient = ${ingredient}")
        ingredients.add(ingredient)
        total++

        ingredient.fresh = checkAgainstRanges(ingredient)

        if (ingredient.fresh) {
            fresh++
        } else
        {
            spoiled++
        }

    }

    fun numberOfIngredients() : Long {
        return numberOfIngredients
    }

    fun countSpoiledIngredients(): Long {

        var count = 0L

        ingredients.forEach { ingredient ->


            val fresh = checkAgainstRanges(ingredient)


            if (!fresh) {
                count++
            }


        }

        return count

    }

    private fun checkAgainstRanges(ingredient: Ingredient): Boolean {
        var fresh = false
        freshRanges.forEach { freshRange ->
            val includes = freshRange.includes(ingredient.id)
            fresh = fresh || includes
        }
        return fresh
    }

    fun totalPossibleFreshIds() {
        freshIds.size
    }

    fun countPossibleFreshIngredients() : ULong {

        var total : ULong = 0u

//        return freshRanges.sumOf { range -> range.total() }

        freshRanges.forEach { range ->
            val rangeTotal = range.total().toULong()
//            println("   rangeTotal = ${rangeTotal}")
            total = total + rangeTotal
//            println("total = ${total}")
        }


        return total

    }

    fun numberOfRanges() : Int {
        return freshRanges.size
    }

}