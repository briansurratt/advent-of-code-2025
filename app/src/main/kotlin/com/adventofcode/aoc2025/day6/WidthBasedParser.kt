package com.adventofcode.aoc2025.day6

class WidthBasedParser(val widths : List<Int>) {

    fun line (line:String) : List<String> {

        println(line)
        val output = mutableListOf<String>()

        var copy = line


        widths.forEach { width ->

            val token = copy.take(width)
            copy = copy.drop(width+1)

            output.add(token)


        }

        return output

    }


}