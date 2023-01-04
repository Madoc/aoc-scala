package aoc.y2022

import aoc.model.io.StringPuzzleInput
import aoc.model.problem.Problem
import aoc.y2022.AOC2022Day01Part1Problem.Result

trait AOC2022Day01Part1Problem extends Problem.ForAOCDay[Result]:
  def calorieReport: StringPuzzleInput

  override def day: Int = 1
  override def title: String = "Calorie Counting Part 1"

  override def canonicalAnswer(result: Result): String = result.calories.toString
  override def detailedAnswer(result: Result): String = s"Elf ${result.elfNumber} with ${result.calories} calories"

case object AOC2022Day01Part1Problem extends AOC2022Day01Part1Problem:
  final case class Result(elfNumber: Int, calories: Int)

  override val calorieReport: StringPuzzleInput = StringPuzzleInput.fromResource("aoc2022/day01/calorie_report.txt")
