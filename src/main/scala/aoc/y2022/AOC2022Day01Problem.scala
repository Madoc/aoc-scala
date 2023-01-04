package aoc.y2022

import aoc.model.io.StringPuzzleInput
import aoc.model.problem.Problem
import aoc.y2022.AOC2022Day01Problem.Result

trait AOC2022Day01Problem extends Problem.ForAOCDay[Result]:
  def calorieReport: StringPuzzleInput

case object AOC2022Day01Problem extends AOC2022Day01Problem:
  final case class Result(elfNumber: Int, calories: Int)

  override def day: Int = 1
  override def title: String = "Calorie Counting"

  override def calorieReport: StringPuzzleInput = StringPuzzleInput.fromResource("aoc2022/day01/calorie_report.txt")

  override def canonicalAnswer(result: Result): String = result.calories.toString
  override def detailedAnswer(result: Result): String = s"Elf ${result.elfNumber} with ${result.calories} calories"
