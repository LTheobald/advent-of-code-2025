package aoc

import aoc.core.Day
import kotlin.system.exitProcess

class Runner(private val registry: Map<Int, () -> Day>) {
    fun run(args: Array<String>) {
        if (registry.isEmpty()) {
            println("No days registered yet.")
            return
        }

        val (dayNumber, part) = parseArgs(args)
        val factory = registry[dayNumber] ?: run {
            println("Day $dayNumber is not registered. Available: ${registry.keys.sorted()}")
            exitProcess(1)
        }

        val day = factory()
        val results = when (part) {
            null -> listOf(1 to day.part1(), 2 to day.part2())
            1 -> listOf(1 to day.part1())
            2 -> listOf(2 to day.part2())
            else -> emptyList()
        }

        println("Day $dayNumber")
        results.forEach { (partNumber, result) ->
            println("Part $partNumber: $result")
        }
    }

    private fun parseArgs(args: Array<String>): Params {
        if (args.isEmpty()) {
            usageAndExit()
        }

        val day = args[0].toIntOrNull() ?: usageAndExit()
        if (day < 1 || day > 25) usageAndExit()

        val part = if (args.size >= 2) {
            args[1].toIntOrNull()?.also {
                if (it !in 1..2) usageAndExit()
            }
        } else null

        return Params(day, part)
    }

    private fun usageAndExit(): Nothing {
        println("Usage: ./gradlew run --args \"<day> [part]\"")
        println("Example: ./gradlew run --args \"5 2\" (runs day 5 part 2)")
        exitProcess(1)
    }

    private data class Params(val day: Int, val part: Int?)
}
