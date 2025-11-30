package aoc.core

abstract class Day(val day: Int) {
    abstract fun part1(): Any
    open fun part2(): Any = "Not implemented"
}
