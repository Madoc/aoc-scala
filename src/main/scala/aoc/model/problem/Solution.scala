package aoc.model.problem

/** Computes the solution to a given problem of type [[P]]. */
trait Solution[-P <: Problem[R], +R]:
  def solve(problem: P): R
