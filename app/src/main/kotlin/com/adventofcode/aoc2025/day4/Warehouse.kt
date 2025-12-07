package com.adventofcode.aoc2025.day4

class Warehouse(private val data : List<MutableList<Boolean>>) {

    fun process() {

        val rows = data.size
        val cols = data.first().size

        for (y in 1..rows) {
            for (x in 1..cols) {
                val coords = XYCoords(x, y)
                val neighbors = coords.expand()
                    .filter { c -> c.x > 0 && c.y > 0 }
                    .filter { c -> c.x <= cols && c.y <= rows }

                val count = neighbors.count { c -> isOccupied(c) }
                println("$coords -> $count")


            }
        }

    }

    fun isOccupied(coords: XYCoords) : Boolean {
        return data[coords.y-1][coords.x-1]
    }

    fun remove(coords: XYCoords) {
        data[coords.y-1][coords.x-1] = false
    }

    data class XYCoords(val x : Int, val y : Int) {

        fun expand() : List<XYCoords> {

            val expansion = mutableListOf<XYCoords>()

            val xRange = x-1..x+1
            val yRange = y-1..y+1

            for (i in xRange) {
                for (j in yRange) {
                    expansion.add(XYCoords(i,j))
                }
            }

            expansion.remove(this)
            if (expansion.size != 8) {
                throw IllegalStateException("had ${expansion.size} elements")
            }

            return expansion
        }

    }




    fun countAccessible(): Int {

        var counter = 0

        val rows = data.size
        val cols = data.first().size

        for (y in 1..rows) {
            for (x in 1..cols) {

                val coords = XYCoords(x, y)

                if (isOccupied(coords)) {

//                    println("checking coords = ${coords}")

                    val neighbors = coords.expand()
                        .filter { c -> c.x > 0 && c.y > 0 }
                        .filter { c -> c.x <= cols && c.y <= rows }

                    val count = neighbors.count { c -> isOccupied(c) }
//                    println("$coords -> $count")

                    if (count < 4) {
                        counter++
                        remove(coords)
                    }

                }

            }
        }

        return counter
    }


}