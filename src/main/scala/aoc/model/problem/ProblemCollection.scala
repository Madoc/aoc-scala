package aoc.model.problem

import aoc.model.description.Title

/** A series of AOC [[Problem|problems]]. Usually related to a certain AOC year. */
trait ProblemCollection:
  def problems: IndexedSeq[Problem[?]]
  def titleString: String

object ProblemCollection:
  def forAOCYear(year: Int)(problems: Problem[?]*): ProblemCollection = ForAOCYear(year, problems.toVector)

  given titleString: Title[ProblemCollection, String] = _.titleString

  final case class ForAOCYear(year: Int, problems: Vector[Problem[?]]) extends ProblemCollection:
    override def titleString: String = s"Advent of Code $year"
