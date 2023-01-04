package aoc.y2022

import aoc.model.problem.Solution
import aoc.y2022.AOC2022Day01Part1Problem.Result

object AOC2022Day01Part1Solution extends Solution[AOC2022Day01Part1Problem, Result]:
  /** Accumulates the running results while reading the calorie report. Only keeps the statistics of the current elf and
   * those of the elf with the maximum calories so far. */
  private final case class State(
    currentElfNumber: Int = 1,
    currentCalories: Int = 0,
    mostCaloriesElfNumber: Int = 0,
    mostCalories: Int = 0):
    def processLine(line: String): State = line.trim match
      case "" => finishCurrentElf
      case calories => addCalories(calories)

    def toResult: Result =
      val finished = finishCurrentElf
      Result(elfNumber = finished.mostCaloriesElfNumber, calories = finished.mostCalories)

    private def addCalories(line: String): State = copy(currentCalories = currentCalories + Integer.parseInt(line))

    private def finishCurrentElf: State =
      if currentCalories != 0 then
        if currentCalories > mostCalories then moveToNextElf.withMostCalories(currentElfNumber, currentCalories)
        else moveToNextElf
      else this

    private def moveToNextElf: State = copy(currentElfNumber = currentElfNumber + 1, currentCalories = 0)
    private def withMostCalories(elfNumber: Int, calories: Int): State =
      copy(mostCaloriesElfNumber = elfNumber, mostCalories = calories)

  override def solve(problem: AOC2022Day01Part1Problem): Result =
    problem.calorieReport.foldLines(State())(_.processLine(_)).toResult
