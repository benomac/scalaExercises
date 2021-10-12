trait Randomizer[A] {
  def draw(): A
}

class IntRandomizer extends Randomizer[Int] {
  override def draw() = {
    import util.Random
    Random.nextInt(101)
  }
}

val intRandomizer = new IntRandomizer


val li = List(1, 2, 3)

for {
  _ <- li
} yield intRandomizer.draw()

intRandomizer.draw()


def printWhenAHundred(): String = {
  val divisibleBy2 = intRandomizer.draw()
  println(divisibleBy2)
  if (divisibleBy2 == 100) "100!"
  else printWhenAHundred()
}

printWhenAHundred()

classOf[String].getCanonicalName
classOf[String].getSimpleName