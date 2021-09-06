import scala.util.{Failure, Success, Try}
//LISTS

val cond: (Int, Int) => Boolean =
  (x, y) => x < y

def insert(x: Int, xs: List[Int]): List[Int] =
  xs match {
    case List() => x ::
      Nil

    case y :: ys =>
      if (x < y) x :: y :: ys
      else y :: insert(x, ys)
  }
insert(3, (List(1, 7, 2, 5)))
insert(3, Nil)

val xs =
  List(1, 2, 3).map { x =>
    List(x, 2 * x, 3 * x)
  }

val xs =
  List(1, 2, 3).flatMap { x =>
    List(x, 2 * x, 3 * x)
  }

//OPTIONAL VALUES

def testOption(x: Double): Option[Double] =
  if (x < 0) None else Some(x * 2)

testOption(2)
testOption(-1)

def deConstructTestOption(d: Double): String = testOption(d) match {
  case None => "Nothing fo you"
  case Some(d) => s"${d.toInt} for you"
}

deConstructTestOption(2)
deConstructTestOption(-2)


//ERROR HANDLING
//TRY

//Try[A] represents a computation that attempted to return an A. It can either be:

  // * a Success[A],
  // * or a Failure.

// The key difference between None and Failures is that the latter provide the reason for the failure:
def testTry(x: Double): Try[Double] =
  if (x < 0) Failure(new IllegalArgumentException("'x' cannot be negative"))
  else Success(x + 2)

testTry(-2)
testTry(2)


//EITHER

//Either can also be useful to handle failures. Basically,
// the type Either[A, B] represents a value that can either be of type A or of type B.
// It can be decomposed in two cases: Left or Right.
// You can use one case to represent the failure and the other to represent the success.
// What makes it different from Try is that you can choose a type other than Throwable to
// represent the exception. Another difference is that exceptions that occur when transforming
// Either values are not converted into failures.

//Since Scala 2.12, Either has map and flatMap. These methods transform the Right case only.
// We say that Either is “right biased”:

def testEither(x: Double): Either[String, Double] =
  if (x > 0) {
  Right(x).map(x => x * 2 * 10)
} else {
  Left("x must be positive")
}

testEither(-2)
testEither(2)

//TUPLES

def pair(i: Int, s: String): (Int, String) = (i, s)

pair(2, "ben")

(1, 2, 3).getClass

//FUNCTIONS AS OBJECTS

val f = new Function1[Int, Int] {
  def apply(x: Int) = x * x
}
f.apply(7)
f(7)

//FOR EXPRESSIONS

val xs: List[Int] = List(1, 2, 3, 4)
val ys: List[Int] = List(1, 2, 3, 4)
//this...
xs.map(
        x => {
          println(x)
          x * 2
        }
      )

//...can be this as a for loop.
for(
  x <- xs
) yield {
  println(x)
  x * 2
}

//Also this...
xs.filter(x => x % 2 == 0)

//...Can be this as a for loop.

for(
  x <- xs if (x % 2 == 0)
) yield x


//Also this...
xs.flatMap(x => ys.map(y => (x, y)))

//...Can be this as a for loop.
for(
  x <- xs;
  y <- ys
) yield (x, y)

// other examples of for loops for flatMap
for {
  x <- xs
  y <- ys if (x % 2 == 0)
} yield (x, y)

for {
  x <- xs if x % 2 == 0
  y <- ys
} yield (x, y)


Range(1, 100, 2).foreach(println)
val ws = Range(start = 1, end = 10, 2)
ws.step


//REPEATED PARAMETERS

//You can define a function that can receive an arbitrary number of
// parameters (of the same type) as follows:

def average(x: Int, xs: Int*): Double = {
  println(xs.getClass)
  (x :: xs.toList).sum.toDouble / (xs.size + 1)
}

average(1, 2, 3)

//Sometimes you want to supply each element of a list as many parameters.
//You can do that by adding a : _* type ascription to your list:
average(1, ws: _*)


//TYPE ALIASES
//  In the same way as you can give meaningful names to expressions,
//you can give meaningful names to type expressions:

type Result = Either[String, (Int, Int)]

def divide(dividend: Int, divisor: Int): Result =
  if (divisor == 0) Left("Division by zero")
  else Right((dividend / divisor, dividend % divisor))
divide(8, 4)
divide(23, 7)