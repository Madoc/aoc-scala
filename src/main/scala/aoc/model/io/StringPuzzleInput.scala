package aoc.model.io

import java.io.{BufferedInputStream, InputStream}

trait StringPuzzleInput:
  def foldCharacters[A](zero: A)(f: (A, Char) => A): A

  def foldLines[A](zero: A)(f: (A, String) => A): A =
    val buffer = StringBuilder()
    val r = foldCharacters(zero)((acc, ch) =>
      ch match
        case '\r' => acc // Gracefully ignore Windows line terminators.
        case '\n' => val line = buffer.toString(); buffer.clear(); f(acc, line)
        case _ => buffer.append(ch); acc
    )
    if buffer.nonEmpty then f(r, buffer.toString()) else r

object StringPuzzleInput:
  def fromResource(path: String): StringPuzzleInput = FromInputStream(() =>
    val stream = getClass.getClassLoader.getResourceAsStream(path)
    if stream == null then sys.error(s"Resource not found on classpath: $path")
    stream
  )

  private final class FromInputStream(access: () => InputStream) extends StringPuzzleInput:
    override def foldCharacters[A](zero: A)(f: (A, Char) => A): A =
      var acc = zero
      val stream = access()
      try
        val in = BufferedInputStream(stream)
        var goOn = true
        while goOn do
          in.read() match
            case -1 => goOn = false
            case ch => acc = f(acc, ch.toChar)
      finally stream.close()
      acc
