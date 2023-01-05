package aoc.y2022

import aoc.model.io.StringPuzzleInput
import minitest.SimpleTestSuite

object AOC2022Day01Suite extends AOC2022TestSuite:
  test("Example part 1")(assertSolution(ExampleProblemPart1, "24000"))
  test("Example part 2")(assertSolution(ExampleProblemPart2, "45000"))

  private object ExampleProblemPart1 extends AOC2022Day01Part1Problem:
    override def calorieReport: StringPuzzleInput = StringPuzzleInput.fromString("""1000
      |2000
      |3000
      |
      |4000
      |
      |5000
      |6000
      |
      |7000
      |8000
      |9000
      |
      |10000""".stripMargin)

  private object ExampleProblemPart2 extends AOC2022Day01Part2Problem:
    override def calorieReport: StringPuzzleInput = ExampleProblemPart1.calorieReport
