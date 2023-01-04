package aoc.model.problem

/** Gives an optional spoiler, in terms of the correct canonical answer, for a given problem. */
trait SolutionSpoilers:
  def spoilerOpt(problem: Problem[?]): Option[String]
