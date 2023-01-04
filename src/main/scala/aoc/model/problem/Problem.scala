package aoc.model.problem

import aoc.model.description.Title

/** Programmatic information related to a certain AOC problem. Useful for printing out the results in a nice,
 * human-readable fashion. Problems usually belong to a [[ProblemCollection]].
 *
 * @tparam R result type for computing the solution. */
sealed trait Problem[-R]:
  def canonicalAnswer(result: R): String
  def detailedAnswer(result: R): String
  def solve(solution: Solution[this.type, R]): ProblemAnswer =
    val r = solution.solve(this)
    ProblemAnswer(canonicalAnswer(r), detailedAnswer(r))

object Problem:
  given titleString: Title[Problem[?], String] = _ match
    case p: ForAOCDay[?] => s"Day ${p.day}: ${p.title}"

  trait ForAOCDay[-R] extends Problem[R]:
    def day: Int
    def title: String
