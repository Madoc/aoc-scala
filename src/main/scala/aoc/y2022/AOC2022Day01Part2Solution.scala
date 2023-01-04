package aoc.y2022

import aoc.model.problem.Solution
import aoc.y2022.AOC2022Day01Part2Problem.{ElfCalories, Result}

object AOC2022Day01Part2Solution extends Solution[AOC2022Day01Part2Problem, Result]:
  /** Keeps track of the current elf and the top elves while iterating over the calorie report. */
  private final case class State(
    current: ElfCalories = ElfCalories(number = 1, calories = 0),
    top: TopElves = TopElves()):
    def processLine(line: String): State = line.trim match
      case "" => finishCurrentElf
      case calories => copy(current = current.addCalories(Integer.parseInt(calories)))

    def toResult: Result = finishCurrentElf.top.toResult

    private def finishCurrentElf: State =
      if current.nonEmpty then copy(current = current.nextElf, top = top.add(current))
      else this

  /** Always keeps the top 3 elves with the most calories when `add` is called. */
  private final case class TopElves(top3: Vector[ElfCalories] = Vector.empty):
    def add(elf: ElfCalories): TopElves = copy(top3 = (top3 :+ elf).sorted.reverse.take(3))
    def toResult: Result = top3 match
      case Vector(place1, place2, place3) => Result(place1, place2, place3)
      case _ => sys.error("Didn't find at least three elves in the report.")

  given Ordering[ElfCalories] = Ordering.by(_.calories)

  extension (elf: ElfCalories)
    def addCalories(calories: Int): ElfCalories = elf.copy(calories = elf.calories + calories)
    def nextElf: ElfCalories = ElfCalories(number = elf.number + 1, calories = 0)
    def nonEmpty: Boolean = elf.calories != 0

  override def solve(problem: AOC2022Day01Part2Problem): Result =
    problem.calorieReport.foldLines(State())(_.processLine(_)).toResult
