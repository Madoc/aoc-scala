package aoc.model.description

/** Typeclass for an object [[O]]'s title, as an instance of [[R]]. */
trait Title[-O, +R]:
  def apply(o: O): R

object Title:
  def apply[O, R](o: O)(using Title[O, R]): R = summon(o)
