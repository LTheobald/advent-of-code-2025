## Advent of Code 2025 (Kotlin)

Lightweight scaffold for daily Kotlin solutions.

### Quick start
- Requirements: JDK 21+ and Gradle. If you do not have Gradle installed, install it (`brew install gradle`), then run `gradle wrapper --gradle-version 8.10.2 --distribution-type=bin` once to generate the wrapper scripts (`./gradlew`).
- Put your puzzle input in `inputs/dayXX.txt` (e.g., `inputs/day01.txt`).
- Run a solution: `./gradlew run --args "1"` (runs both parts) or `./gradlew run --args "1 2"` (part 2 only).

### Project layout
- `src/main/kotlin/aoc/core`: tiny framework (`Day`, `Input`).
- `src/main/kotlin/aoc/day01/Day01.kt`: starter solution stub.
- `inputs/`: where you paste puzzle inputs (kept via `.gitkeep`).
- `scripts/new-day.sh`: scaffolds a new day class.
- `src/main/kotlin/aoc/Days.kt`: register each day here so the runner can find it.

### Adding a new day
1) Run `scripts/new-day.sh <day>` to generate `src/main/kotlin/aoc/dayXX/DayXX.kt`.
2) Register it in `src/main/kotlin/aoc/Days.kt`, e.g. `5 to { Day05() }`.
3) Add your input to `inputs/dayXX.txt`.
4) Run with `./gradlew run --args "XX"` (or specify part).

### Input helpers
- `Input.readLines(day, suffix?)` loads `inputs/dayXX[-suffix].txt` as `List<String>`.
- `Input.readText(day, suffix?)` returns raw `String`.
- Use `suffix` if you want alternative files (e.g., `test`).

### CLI usage
```
./gradlew run --args "3"      # run both parts of day 3
./gradlew run --args "3 1"    # run part 1 only
```

### Notes
- The default `Day01` just counts input lines; replace with your logic.
- If you prefer not to commit puzzle inputs, add `inputs/` to `.gitignore`.
