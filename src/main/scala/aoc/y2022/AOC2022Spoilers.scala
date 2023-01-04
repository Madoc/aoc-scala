package aoc.y2022

import aoc.model.problem.{Problem, SolutionSpoilers}

// BE CAREFUL! Spoilers ahead.
case object AOC2022Spoilers extends SolutionSpoilers:
  override def spoilerOpt(problem: Problem[?]): Option[String] = problem match
    case AOC2022Day01Problem => Some("70116")
    case _ => None
