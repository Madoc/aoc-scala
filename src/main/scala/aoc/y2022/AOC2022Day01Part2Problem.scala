package aoc.y2022

import aoc.model.io.StringPuzzleInput
import aoc.model.problem.Problem
import aoc.y2022.AOC2022Day01Part2Problem.Result

trait AOC2022Day01Part2Problem extends Problem.ForAOCDay[Result]:
  def calorieReport: StringPuzzleInput

  override def day: Int = 1
  override def title: String = "Calorie Counting Part 2"

  override def canonicalAnswer(result: Result): String = result.totalCalories.toString
  override def detailedAnswer(result: Result): String = result.toString

case object AOC2022Day01Part2Problem extends AOC2022Day01Part2Problem:
  final case class Result(place1: ElfCalories, place2: ElfCalories, place3: ElfCalories):
    def totalCalories: Int = place1.calories + place2.calories + place3.calories
    override def toString: String = s"$place1 + $place2 + $place3 = $totalCalories calories"

  final case class ElfCalories(number: Int, calories: Int):
    override def toString: String = s"$calories calories (Elf $number)"

  override val calorieReport: StringPuzzleInput = AOC2022Day01Part1Problem.calorieReport
