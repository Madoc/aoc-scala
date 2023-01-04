package aoc.model.problem

/** After computing a solution to a problem, this result object contains both the canonical answer, which is to be
 * entered in the AOC form field, and a possibly more detailed answer for printing to a report. */
final case class ProblemAnswer(canonicalAnswer: String, detailedAnswer: String)
