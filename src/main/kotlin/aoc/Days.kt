package aoc

import aoc.core.Day
import aoc.day01.Day01

object Days {
    val registry: Map<Int, () -> Day> = mapOf(
        1 to { Day01() },
    )
}
