package aoc.model.io

import aoc.model.description.Title
import aoc.model.problem.{Problem, ProblemAnswer, ProblemCollection}

import scala.io.AnsiColor

/** Imperative output interface for reporting problem solutions. */
trait SolutionLog:
  def onProblemCollectionStarted(collection: ProblemCollection): Unit
  def onProblemCollectionFinished(): Unit

  def onProblemStarted(problem: Problem[?]): Unit

  def onProblemAnswered(answer: ProblemAnswer, correctness: Option[Boolean]): Unit
  def onProblemException(exception: Exception): Unit
  def onProblemNoSolutionFound(): Unit

object SolutionLog:
  /** Writes a comprehensive report to the console. */
  case object ToConsole extends SolutionLog:
    override def onProblemCollectionStarted(collection: ProblemCollection): Unit =
      print(AnsiColor.CYAN); print(Title(collection)); print(AnsiColor.RESET); println(); println(" ")
    override def onProblemCollectionFinished(): Unit = ()

    override def onProblemStarted(problem: Problem[?]): Unit =
      print(AnsiColor.MAGENTA); print(Title(problem)); print(AnsiColor.WHITE); print(" -- "); print(AnsiColor.RESET);
      solutionStartTimeMillis = System.currentTimeMillis()

    override def onProblemAnswered(answer: ProblemAnswer, correctness: Option[Boolean]): Unit =
      print(answer.detailedAnswer); reportSolutionDuration(); print(" ")
      correctness match
        case Some(true) => print(AnsiColor.GREEN); print("✓"); print(AnsiColor.RESET)
        case Some(false) => print(AnsiColor.RED); print("✗"); print(AnsiColor.RESET)
        case None => print(AnsiColor.BLUE); print("?"); print(AnsiColor.RESET)
      println()
    override def onProblemException(exception: Exception): Unit =
      print(AnsiColor.RED); print("Caught exception while computing solution:"); print(AnsiColor.RESET)
      reportSolutionDuration(); println()
      System.out.flush()
      exception.printStackTrace()
    override def onProblemNoSolutionFound(): Unit =
      print(AnsiColor.RED); print("No solution algorithm found."); print(AnsiColor.RESET); reportSolutionDuration()
      println()

    private def reportSolutionDuration(): Unit =
      val duration: String =
        if solutionStartTimeMillis < 0 then "?"
        else (System.currentTimeMillis() - solutionStartTimeMillis).toString + " ms"
      solutionStartTimeMillis = -1
      print(AnsiColor.YELLOW); print(" " + duration); print(AnsiColor.RESET)

    private var solutionStartTimeMillis: Long = -1

  /** Ignores all calls. Useful for unit testing. */
  case object NoOp extends SolutionLog:
    override def onProblemCollectionStarted(collection: ProblemCollection): Unit = ()
    override def onProblemCollectionFinished(): Unit = ()
    override def onProblemStarted(problem: Problem[?]): Unit = ()
    override def onProblemAnswered(answer: ProblemAnswer, correctness: Option[Boolean]): Unit = ()
    override def onProblemException(exception: Exception): Unit = ()
    override def onProblemNoSolutionFound(): Unit = ()
