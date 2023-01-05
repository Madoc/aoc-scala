package aoc.y2022

import aoc.model.problem.Problem
import minitest.SimpleTestSuite

trait AOC2022TestSuite extends SimpleTestSuite:
  protected def assertSolution(exampleProblem: Problem[?], canonicalAnswer: String): Unit =
    AOC2022.solver.answerOpt(exampleProblem).map(_.canonicalAnswer) match
      case Some(answer) => assertEquals(answer, canonicalAnswer)
      case None => fail("No solution implemented.")
