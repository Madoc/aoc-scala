package aoc.run

import aoc.model.io.SolutionLog
import aoc.model.problem.SolutionCollection

/** Runs a given collection of problems and solutions, and prints a comprehensive report to the given solution log. */
object RunCollection:
  def apply(collection: SolutionCollection, log: SolutionLog): Unit =
    log.onProblemCollectionStarted(collection.problems)

    for problem <- collection.problems.problems do
      log.onProblemStarted(problem)
      try
        collection.solver.answerOpt(problem) match
          case Some(answer) =>
            log.onProblemAnswered(answer, collection.spoilers.spoilerOpt(problem).map(_ == answer.canonicalAnswer))
          case None => log.onProblemNoSolutionFound()
      catch case exception: Exception => log.onProblemException(exception)

    log.onProblemCollectionFinished()
