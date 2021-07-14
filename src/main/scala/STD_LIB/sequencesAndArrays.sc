//Scala provides a data structure, the array, which stores a fixed-size sequential
// collection of elements of the same type. An array is used to store a collection of data,
// but it is often more useful to think of an array as a collection of variables of the same type.
//
//A list can be converted to an array:

val l = List(1, 2, 3)
val a = l.toArray

//Sequences are special cases of iterable collections of class Iterable.
// Unlike iterables, sequences always have a defined order of elements.

//Any sequence can be converted to a list:

val a = Array(1, 2, 3)
val t = a.toSeq
val l = t.toList


//You can create a sequence from a for loop:
//creates IndexedSeq
val s = for(v <- 1 to 4) yield v
s.toList

//Turns IndexedSeq toList
val s2 = {
  for (v <- 1 to 4)
    yield v
}.toList

//Also Turns IndexedSeq toList
val s3 = (for(v <- 1 to 4) yield v).toList

//You can create a sequence from a for loop with a filter:
val sa = for (v <- 1 to 10 if v % 3 == 0) yield v
sa.toList

//You can filter any sequence based on a predicate:

val sb = Seq("hello", "to", "you")
val filtered = sb.filter(_.length > 2)

//You can also filter Arrays in the same way

val a2 = Array("hello", "to", "you", "again")
val filtered = a2.filter(_.length > 3)

//You can map values in a sequence through a function:

val s4 = Seq("hello", "world")
val r = s4 map {
  _.reverse //reverses the order of the words, NOT the Seq
}























