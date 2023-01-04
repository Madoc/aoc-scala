package aoc.y2022

import aoc.model.problem.*

/** Advent of Code 2022. */
object AOC2022 extends SolutionCollection:
  override val problems: ProblemCollection = ProblemCollection.forAOCYear(2022)(
    AOC2022Day01Part1Problem,
    AOC2022Day01Part2Problem
  )

  override val solver: Solver = new Solver:
    override def answerOpt[R](problem: Problem[R]): Option[ProblemAnswer] = problem match
      case p: AOC2022Day01Part1Problem => Some(p.solve(AOC2022Day01Part1Solution))
      case p: AOC2022Day01Part2Problem => Some(p.solve(AOC2022Day01Part2Solution))
      case _ => None

  override def spoilers: SolutionSpoilers = AOC2022Spoilers
