package aoc.core

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

object Input {
    private val baseDir: Path = Paths.get("inputs")

    fun readText(day: Int, suffix: String = ""): String {
        val path = resolve(day, suffix)
        require(Files.exists(path)) { "Input file not found: $path" }
        return Files.readString(path).trimEnd()
    }

    fun readLines(day: Int, suffix: String = ""): List<String> =
        readText(day, suffix).lines()

    fun resolve(day: Int, suffix: String = ""): Path {
        val suffixPart = suffix.takeIf { it.isNotBlank() }?.let { "-$it" } ?: ""
        val filename = "day%02d%s.txt".format(day, suffixPart)
        return baseDir.resolve(filename)
    }
}
