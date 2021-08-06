//The next trait from the top in the collections hierarchy is Iterable.
// All methods in this trait are defined in terms of an abstract method,
// iterator, which yields the collection's elements one by one.
// The foreach method from trait Traversable is implemented in Iterable in terms of iterator. Here is the actual implementation:

//def foreach[U](f: Elem => U): Unit = {
//  val it = iterator
//  while (it.hasNext) f(it.next())
//}

//
val list = List(3, 5, 9, 11, 15, 19, 21)
val it = list.iterator
if (it.hasNext)
  it.next

//grouped will return fixed-size Iterable chunks of an Iterable:

val list = List(3, 5, 9, 11, 15, 19, 21, 24, 32)
val it = list grouped 3

//sliding will return an Iterable that shows a sliding window of an Iterable.
val list = List(3, 5, 9, 11, 15, 19, 21, 24, 32)
val it = list sliding 3
it.next()
it.next
it.next

//sliding can take the size of the window as well the size of the step during each iteration:

val list = List(3, 5, 9, 11, 15, 19, 21, 24, 32)
val it = list sliding (3, 3)
it.next()
it.next
it.next

//takeRight is the opposite of 'take' in Traversable. It retrieves the last elements of an Iterable:

val list = List(3, 5, 9, 11, 15, 19, 21, 24, 32)

//dropRight will drop a specified number of elements from the right:

val list = List(3, 5, 9, 11, 15, 19, 21, 24, 32)
list dropRight(3)


val xs = List(3, 5, 9)
val ys = List("Bob", "Ann")

//zipAll
// The -1 position is for the first list, the 12 is for the second list, either will go
// into the list that doesn't have enough parameters to zip.
(xs zipAll (ys, -1, 12))

//sameElements will return true if the two Iterables produce the same
// elements in the same order. The iterator for a SET created with less
// than 5 values will return elements in the order in which they were added,
// rather than the consistent, hash-based ordering used by iterators for larger Sets:

val xt = List(3, 5, 6)
val yt = List("Bob", "Ann", "Stella")
(xt zipAll (yt, -1, "?"))

val xs = List("Manny", "Moe", "Jack")
val ys = List("Manny", "Moe", "Jack")
xs.iterator.sameElements(ys)

val xt = List("Manny", "Moe", "Jack")
val yt = List("Manny", "Jack", "Moe")
xt.iterator.sameElements(yt)

val xs1 = Set(3, 2, 1, 4, 5, 6, 7)
val ys1 = Set(7, 2, 1, 4, 5, 6, 3)
xs1.iterator.sameElements(ys1)

val xt1 = Set(1, 2, 3)
val yt1 = Set(3, 2, 1)
xt1.iterator.sameElements(yt1)