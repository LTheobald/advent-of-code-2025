#!/usr/bin/env bash
set -euo pipefail

day="${1:-}"
if [[ -z "$day" ]]; then
  echo "Usage: scripts/new-day.sh <day-number>"
  exit 1
fi

if ! [[ "$day" =~ ^[0-9]+$ ]] || [[ "$day" -lt 1 || "$day" -gt 25 ]]; then
  echo "Day must be between 1 and 25"
  exit 1
fi

printf -v padded "day%02d" "$day"
pkg_dir="src/main/kotlin/aoc/$padded"
file_path="$pkg_dir/Day${padded^}.kt"

if [[ -e "$file_path" ]]; then
  echo "$file_path already exists"
  exit 1
fi

mkdir -p "$pkg_dir"
cat > "$file_path" <<EOF
package aoc.$padded

import aoc.core.Day
import aoc.core.Input

class Day${padded^} : Day($day) {
    private val lines = Input.readLines(day)

    override fun part1(): Any {
        // TODO: solve part 1
        return lines.size
    }

    override fun part2(): Any {
        // TODO: solve part 2
        return "Not solved yet"
    }
}
EOF

echo "Created $file_path"
echo "Add your input at inputs/${padded}.txt"
