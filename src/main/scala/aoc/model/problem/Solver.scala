package aoc.model.problem

/** Solves known [[Problem|problems]]. */
trait Solver:
  def answerOpt[R](problem: Problem[R]): Option[ProblemAnswer]
