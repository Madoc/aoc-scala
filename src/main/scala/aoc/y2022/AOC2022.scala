package aoc.y2022

import aoc.model.problem.{Problem, ProblemAnswer, ProblemCollection, Solution, SolutionCollection, SolutionSpoilers, Solver}

/** Advent of Code 2022. */
object AOC2022 extends SolutionCollection:
  override val problems: ProblemCollection = ProblemCollection.forAOCYear(2022)(AOC2022Day01Problem)

  override val solver: Solver = new Solver:
    override def answerOpt[R](problem: Problem[R]): Option[ProblemAnswer] = problem match
      case p: AOC2022Day01Problem => Some(p.solve(AOC2022Day01Solution))
      case _ => None

  override def spoilers: SolutionSpoilers = AOC2022Spoilers
