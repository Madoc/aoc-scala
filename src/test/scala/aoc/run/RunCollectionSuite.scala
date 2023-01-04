package aoc.run

import aoc.model.io.SolutionLog
import aoc.y2022.AOC2022
import minitest.SimpleTestSuite

object RunCollectionSuite extends SimpleTestSuite:
  test("AOC 2022 runs without exceptions")(RunCollection(AOC2022, SolutionLog.NoOp))
