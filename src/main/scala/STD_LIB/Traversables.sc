//At the top of the collection hierarchy is the trait Traversable.
// Its only abstract operation is foreach:

//def foreach[U](f: Elem => U)

//Collection classes that implement Traversable just need to define this method;
// all other methods can be inherited from Traversable.

//The foreach method is meant to traverse all elements of the collection,
// and apply the given operation, f, to each element. The type of the operation is
// Elem => U, where Elem is the type of the collection's elements and U is an arbitrary
// result type. The invocation of f is done for its side effect only; in fact any
// function result of f is discarded by foreach.

val set = Set(1, 9, 10, 22)
val list = List(3, 4, 5, 10)

val result = set ++ list
result.size // 10 is missing as sets can only contain unique elements

val result2 = list ++ set
result2.size

val set = Set(1, 3, 4, 6)
val result = set.map(_ * 4)
result.lastOption

//flatten will "pack" all child Traversables into a single Traversable:

val list = List(List(1), List(2, 3, 4), List(5, 6, 7), List(8, 9, 10))
list.flatten

//flatMap will not only apply the given function on all elements of a Traversable,
// but all elements within the elements and flatten the results:

val list = List(List(1), List(2, 3, 4), List(5, 6, 7), List(8, 9, 10))
val result = list.flatMap(_.map(_ * 4))
result

//flatMap of Options will filter out all Nones but keep the Somes:

val list = List(1, 2, 3, 4, 5)
val result = list.flatMap(it => if (it % 2 == 0) Some(it) else None)


//"collect" will apply a partial function to all elements of a "Traversable" and return a different
//collection. In this exercise, a case fragment is a partial function:

val list = List(4, 6, 7, 8, 9, 13, 14)
val result = list.collect {
  case x: Int if (x % 2 == 0) => x * 3
}

//Two case fragments can be chained to create a more robust result:
val list = List(4, 6, 7, 8, 9, 13, 14)
val partialFunction1: PartialFunction[Int, Int] = {
  case x: Int if x % 2 == 0 => x * 3
}
val partialFunction2: PartialFunction[Int, Int] = {
  case y: Int if y % 2 != 0 => y * 4
}
val result = list.collect(partialFunction1 orElse partialFunction2)

val fr = Set(3, 5, 2, 5, 2)
fr.toSeq


val list = List(4, 6, 7, 8, 9, 13, 14)
val result = list.to(LazyList)
result.isInstanceOf[LazyList[_]]
val result2 = result take 3
result2

val list = List(("Phoenix", "Arizona"), "Austin" -> "Texas")
list.getClass
val result = list.toMap















