// LISTS

//Scala Lists are quite similar to arrays, which
// means all the elements of a list have the same type -
// but there are two important differences.
// First, lists are immutable, which means elements
// of a list cannot be changed by assignment.
// Second, lists represent a linked list whereas arrays are flat.
// The type of a list that has elements of type T is written as List[T]

// eq tests identity (same object):
//val a = List(1, 2, 3)
//val b = List(1, 2, 3)
//(a eq b) should be(false)

//== tests equality (same content):
//
//val a = List(1, 2, 3)
//val b = List(1, 2, 3)
//(a == b) should be(true)

// Nil lists are identical, even of different types:

//Lists can be accessed via head, headOption and tail.
// Accessing a list via head is unsafe and may result in a
// IndexOutOfBoundsException.
//
//val a = List(1, 2, 3)
//a.headOption should equal(Some(1))
//a.tail should equal(List(2, 3))

val a = List(1, 2, 3)
val b = Nil
a.headOption.getOrElse("The list is empty")
b.headOption.getOrElse("The list is empty")
//b.head

//lists are immutable
val a = List(1, 3, 5, 7, 9)

// removes the elements that == 5
val b = a.filterNot(_ == 5)
val b = a.filterNot(v => v == 5)

// removes the elements that != 5
val b = a.filter(_ == 5)
val b = a.filter(v => v == 5)

//Lists can be reduced with a mathematical operation:
val a = List(1, 3, 5, 7)
a.reduceLeft(_+_)
a.reduceLeft(_*_)

//foldLeft is like reduce, but with an explicit starting value:
val a = List(1, 3, 5, 7)
a.foldLeft(0)(_ + _)
a.foldLeft(10)(_ + _)
a.foldLeft(1)(_ * _)
a.foldLeft(0)(_ * _)

//You can prepend elements to a List to get a new List:

val b = 0 :: a
val d = Nil
val c = 3 :: d

//Lists reuse their tails:
val d = Nil
val c = 3 :: d
val b = 2 :: c 
val a = 1 :: b