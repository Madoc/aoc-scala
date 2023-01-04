package aoc

import aoc.model.description.Title
import aoc.model.problem.SolutionCollection
import aoc.y2022.AOC2022
import minitest.SimpleTestSuite

object AOCSuite extends SimpleTestSuite:
  private val collections: Seq[SolutionCollection] = Seq(AOC2022)

  for
    collection <- collections
    problem <- collection.problems.problems
  do
    test(s"${Title(collection.problems)}: ${Title(problem)}") {
      collection.solver.answerOpt(problem) match
        case None => () // Nothing to test if no answer is computed.
        case Some(answer) => // At this point, we already validated that no exception occurred.
          collection.spoilers.spoilerOpt(problem) match
            case Some(correct) if correct == answer.canonicalAnswer => () // Success
            case Some(_) => fail("Incorrect solution.")
            case None => () // We don't know the spoiler, so we can't validate it.
    }
