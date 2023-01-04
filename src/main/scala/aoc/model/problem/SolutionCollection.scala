package aoc.model.problem

/** A combination of a [[ProblemCollection]] and a fitting [[Solver]] for those problems, along with potential
 * [[SolutionSpoilers]]. */
trait SolutionCollection:
  def problems: ProblemCollection
  def solver: Solver
  def spoilers: SolutionSpoilers
