import scala.annotation.tailrec
import scala.language.implicitConversions


abstract class SemiGroup[A] {
  def add(x: A, y: A): A
}
abstract class Monoid[A] extends SemiGroup[A] {
  def unit: A
  def doSomething(x: A): A
}

//abstract class newThing[A] extends Monoid[A] {
//
//}

implicit object StringMonoid extends Monoid[String] {
  def add(x: String, y: String): String = x concat y
  def unit: String = ""
  def doSomething(x: String): String = x.toUpperCase()
}
implicit object IntMonoid extends Monoid[Int] {
  def add(x: Int, y: Int): Int = x + y
  def unit: Int = 0
  def doSomething(x: Int): Int = x
}
def sum[A](xs: List[A])(implicit m: Monoid[A]): A =
  if (xs.isEmpty) m.unit
  else m.add(xs.head, sum(xs.tail))

println(sum(List(1, 2, 3)))
println(sum(List("a", "b", "c")))

//Creating a method isOdd for Int, which doesn't exist:

object TestObject {
  class KoanIntWrapper(val original: Int) {
    def isOdd = original % 2 != 0

    def isEven = !isOdd

    def toStringAndReverse: String =
      original.toString.reverse
  }

  implicit def thisMethodNameIsIrrelevant(value: Int): KoanIntWrapper =
    new KoanIntWrapper(value)
}

object AnotherTestObject{
  //Implicits rules can be imported into your scope with an import:
  import TestObject._

  val checkOne = 3.isOdd
  val checkTwo = 20.isOdd
  val checkThree = 30.toStringAndReverse
  val checkFour = 20.isEven
}

import AnotherTestObject._
checkOne
checkTwo
checkThree
checkFour


//Implicits can be used to automatically convert a value's type to another:
import java.math.BigInteger
implicit def Int2BigIntegerConvert(value: Int): BigInteger =
  new BigInteger(value.toString)

def add(a: Int, b: Int) = a.add(b)
add(3, 6) == 9
add(3, 6) == Int2BigIntegerConvert(9)
add(3, 6) == (9: BigInteger)
add(3, 6).intValue


//Implicits can be used to declare a value to be provided as a default as long
// as an implicit value is set with in the scope. These are called Implicit Function Parameters:

def howMuchCanIMake_?(hours: Int)(implicit dollarsPerHour: BigDecimal) =
  dollarsPerHour * hours

implicit val hourlyRate: BigDecimal = BigDecimal(34)

howMuchCanIMake_?(30)


//Default arguments, though, are preferred to Implicit Function Parameters:
def howMuchCanIMake2_?(hours: Int, amount: BigDecimal = 34, currencyName: String = "Dollars") =
  (amount * hours).toString() + " " + currencyName
howMuchCanIMake2_?(30)
howMuchCanIMake2_?(30, 95)