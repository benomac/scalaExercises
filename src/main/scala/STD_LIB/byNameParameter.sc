//() => Int is a Function type that takes a Unit type.
// Unit is known as void to a Java programmer.
// The function returns an Int. You can place this as a method
// parameter so that you can you use it as a block, but still it doesn't look quite right:

def calc(x: () => Int): Either[Throwable, Int] = {
  try Right(x()) // An explicit call of the x function
  catch {
    case b: Throwable => Left(b)
  }
}

val y = calc { () =>
  14 + 15
}

//A by-name parameter does the same thing as the
// previous koan but there is no need to explicitly handle Unit or ().
// This is used extensively in Scala to create blocks:

def calc(x: => Int, d: String): Either[Throwable, Int] = {
  // x is a call by-name parameter
  println(d.toInt)
  try Right(x)
  catch {
    case b: Throwable => Left(b)
  }

}

val y = calc({
  // This looks like a natural block"
  println("Here we go!") // Some superfluous call
  val z = List(1, 2, 3, 4) // Another superfluous call
  49 + 20
}, "7")

object PigLatinizer {
  def apply(x: => String) = x.tail + x.head + "ay"
}

val result = PigLatinizer {
  val x = "pret"
  val z = "zel"
  x ++ z //concatenate the strings
}