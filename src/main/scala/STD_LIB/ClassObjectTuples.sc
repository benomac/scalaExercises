import java.util.Objects
// CLASS TO TUPLES

//CLASS
class Point(x: Int, val y: Int) {
  override def toString(): String = "(" + x + ", " + y + ")"
}

val b = new Point(1, 2)
println(b)


//OPTION

def maybeItWillReturnSomething(flag: String): Option[String] = {
  if (flag.length == 2) Some(s"found $flag") else None
}

val value1 = maybeItWillReturnSomething("ben")
val value2 = maybeItWillReturnSomething("be")

value1.getOrElse("None")
value2.getOrElse("None")

//.map() with option
val number: Option[Int] = Some(3)
val noNumber: Option[Int] = None
val result1 = number.map(_ * 3)
val result2 = noNumber.map(_ * 3)
val a = List(1, 2, 3, 4)
// .fold() with option

a.foldRight(1)(_*_)
val number: Option[Int] = Some(3)
val noNumber: Option[Int] = None
val result1 = number.fold(1)(_ + 3)
val result2 = noNumber.fold(1)(_ * 3)


// Objects

object Greeting {
  def english = "Hi"

  def espanol = "Hola"
}

val x = Greeting
val y = x

class Movie(val name: String, val year: Short, private val actor: String) {
  def allDetails = s"Name: $name, year: $year"

}

object Movie {
  def showActor(x: Movie):String = x.actor

  def academyAwardBestMoviesForYear(x: Short): Option[Movie] = {
    //This is a match statement, more powerful than a Java switch statement!
    x match {
      case 1930 => Some(new Movie("All Quiet On the Western Front", 1930, "person"))
      case 1931 => Some(new Movie("Cimarron", 1931, "person"))
      case 1932 => Some(new Movie("Grand Hotel", 1932, "person"))
      case _ => None
    }
  }
}

Movie.academyAwardBestMoviesForYear(1932).get.name
val grandHotel = new Movie("Grand Hotel", 1932, "man")

// Shows example of object being able to see private vals of Movie class.
Movie.showActor(grandHotel)


// TUPLES
// !!!!!!!!  TUPLES ARE 1 INDEXED  !!!!!!!!!!!!!

//This is syntactic sugar for
val thisIsASugaryTuple = (1, "Ben", List(1, 2, 3))
val thisIsATuple = new Tuple3(1, "Ben", List(1, 2, 3))

// This is how to access elements of a tuple
thisIsASugaryTuple._2 // = Ben

//You can assign multiple variables at once using tuples

val newTuple = ("ben", 38, "software engineer")
//This creates 3 new vals at once, using the values in the above tuple,
//to populate the values of the vals in the below parens
val (name, age, job) = newTuple

name
age
job

//The swap method can be used to swap the elements of a Tuple2:
val tuple = ("apple", 3).swap

