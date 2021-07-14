//Here is an example:

//This trait consists of two methods isSimilar and isNotSimilar. While isSimilar does
// not provide a concrete method implementation (it is abstract in the terminology of Java),
// method isNotSimilar defines a concrete implementation. Consequently,
// classes that integrate this trait only have to provide a concrete implementation for isSimilar.
// The behavior for isNotSimilar gets inherited directly from the trait.
trait Similarity[T] {
  def isSimilar(x: T): Boolean
  def isNotSimilar(x: T): Boolean = !isSimilar(x)
}

case class SimilarityCheck[T](y: T) extends Similarity[T] {
  override def isSimilar(x: T): Boolean = x == y
}

val num: SimilarityCheck[Int] = SimilarityCheck(9)
num.isSimilar(9)
num.isNotSimilar(9)

val text: SimilarityCheck[String] = SimilarityCheck("Ben")

text.isSimilar("Ben")
text.isSimilar("Dawn")
text.isNotSimilar("Ben")
case class Event(name: String)

trait EventListener {
  def listen(event: Event): String
}

class MyListener extends EventListener {
  def listen(event: Event): String = {
    event match {
      case Event("Moose stampede") => "An unfortunate moose stampede occurred"
      case _ => "Nothing of importance occurred"
    }
  }
}

val evt = Event("Moose stampede")
val myListener = new MyListener
myListener.listen(evt)